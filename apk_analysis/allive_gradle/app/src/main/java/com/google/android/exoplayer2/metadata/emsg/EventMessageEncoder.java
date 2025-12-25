package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public final class EventMessageEncoder {

    /* renamed from: a */
    public final ByteArrayOutputStream f10750a;

    /* renamed from: b */
    public final DataOutputStream f10751b;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f10750a = byteArrayOutputStream;
        this.f10751b = new DataOutputStream(byteArrayOutputStream);
    }

    public byte[] encode(EventMessage eventMessage) {
        ByteArrayOutputStream byteArrayOutputStream = this.f10750a;
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = this.f10751b;
        try {
            dataOutputStream.writeBytes(eventMessage.schemeIdUri);
            dataOutputStream.writeByte(0);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            dataOutputStream.writeBytes(str);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeLong(eventMessage.durationMs);
            dataOutputStream.writeLong(eventMessage.f10749id);
            dataOutputStream.write(eventMessage.messageData);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
