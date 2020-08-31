package com.usc.javase.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author jianjianduan
 * @date 2020/8/31 10:06 下午
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    // This method is called with the received message, whenever new data is received from a client
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        // Discard message
//        ((ByteBuf)msg).release();
//        // ByteBuf是一个引用计数器对象，释放它必须显式调用它的release方法

        try{
            ByteBuf in = (ByteBuf) msg;
            if(in.isReadable()){
                System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII));
                System.out.flush();
            }
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }


}
