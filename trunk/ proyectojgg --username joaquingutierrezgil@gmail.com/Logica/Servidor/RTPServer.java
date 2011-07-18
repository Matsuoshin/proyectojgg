/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica.Servidor;

import org.gstreamer.Element;
import org.gstreamer.ElementFactory;
import org.gstreamer.Gst;
import org.gstreamer.Pad;
import org.gstreamer.Pipeline;

/**
 *
 * @author Joaquín
 */
public class RTPServer {

    private Pipeline pipeline;
    private Pipeline pipe;

    /*
    private Element videosrc;
    private Element videosrc1;
    private Element videofilter;
    private Element videofilter1;
    private Element videoencoder;
    private Element videopayloader;
    private Element videosink;
     * 
     */

    private Element audiosrc;
    private Element audiosrc1;
    private Element audiofilter;
    private Element audiofilter1;
    private Element audioencoder;
    private Element audiopayloader;
    private Element audiosink;

    private Element rtpbin;
    private Element rtpsink;
    private Element rtcpsink;
    private Element rtcpsrc;

    private Pad srcpad;
    private Pad sinkpad;

    public RTPServer(){
        Gst.init();

        //Pipeline to hold everything
        pipeline = new Pipeline("RTPSendPipeline");

        audiosrc = ElementFactory.make("filesrc", "source");

        pipeline.addMany();

        pipeline.addMany(audiosrc,audioencoder,audiopayloader,null);
        Element.linkMany(audiosrc,audioencoder,audiopayloader, null);

        //the rtpbin element
        rtpbin = ElementFactory.make("gstrtpbin", "rtpbin");
        pipeline.add(rtpbin);

        //the udp sinks and source that we will use for RTP and RTCP
        rtpsink = ElementFactory.make("udpsink","rtpsink");
        rtpsink.set("host","127.0.0.1");
        rtpsink.set("port","5002");

        rtcpsink = ElementFactory.make("udpsink","rtcpsink");
        rtcpsink.set("host","127.0.0.1");
        rtcpsink.set("port","5003");

        //no need for synchronisation or prerollon the RTCP sink
        rtcpsink.set("async","FALSE");
        rtcpsink.set("sync","FALSE");

        rtcpsrc = ElementFactory.make("udpsrc","rtcpsrc");
        rtcpsrc.set("port","5007");

        pipeline.addMany(rtpsink,rtcpsink,rtcpsrc,null);

        //now link all to the rtpbin, start by getting an RTP sinkpad for session 0
        sinkpad = rtpbin.getRequestPad("send_rtp_sink_0");
        srcpad = audiopayloader.getStaticPad("src");
        srcpad.link(sinkpad);
        System.out.println(sinkpad.toString());
        System.out.println(srcpad.toString());
        //System.out.println(srcpad.isLinked());
        System.out.println();

        //get the RTP srcpad that was created when we requested the sinkpad above and link
        //it to the rtpsink sinkpad
        srcpad = rtpbin.getStaticPad("send_rtp_src_0");
        sinkpad = rtpsink.getStaticPad("sink");
        srcpad.link(sinkpad);
        System.out.println(sinkpad.toString());
        System.out.println(srcpad.toString());
        System.out.println();

        //get an RTCP srcpad for sending RTCP to the receiver
        srcpad = rtpbin.getRequestPad("send_rtcp_src_0");
        sinkpad = rtcpsink.getStaticPad("sink");
        srcpad.link(sinkpad);
        System.out.println(sinkpad.toString());
        System.out.println(srcpad.toString());
        System.out.println();

        //we also want to receive RTCP, request and RTCP sinkpad for session 0 and link
        //it to the srcpad of the udpsrc for RTCP
        srcpad = rtcpsrc.getStaticPad("src");
        sinkpad = rtpbin.getRequestPad("recv_rtcp_sink_0");
        srcpad.link(sinkpad);
        System.out.println(sinkpad.toString());
        System.out.println(srcpad.toString());
    }
}

