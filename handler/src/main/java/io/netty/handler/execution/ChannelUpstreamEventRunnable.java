/*
 * Copyright 2011 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.handler.execution;

import java.util.concurrent.Executor;

import io.netty.channel.ChannelEvent;
import io.netty.channel.ChannelHandlerContext;

/**
 * A {@link ChannelEventRunnable} which sends the specified {@link ChannelEvent} upstream.
 * Most users will not see this type at all because it is used by
 * {@link Executor} implementers only
 */
public class ChannelUpstreamEventRunnable extends ChannelEventRunnable {


    /**
     * Creates a {@link Runnable} which sends the specified {@link ChannelEvent}
     * upstream via the specified {@link ChannelHandlerContext}.
     */
    public ChannelUpstreamEventRunnable(ChannelHandlerContext ctx, ChannelEvent e) {
        super(ctx, e);
    }

   
    /**
     * Sends the event upstream.
     */
    @Override
    public void run() {
        ctx.sendUpstream(e);
    }
}
