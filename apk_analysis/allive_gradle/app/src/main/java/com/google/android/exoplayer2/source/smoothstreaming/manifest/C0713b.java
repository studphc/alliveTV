package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.util.Base64;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.b */
/* loaded from: classes.dex */
public final class C0713b extends AbstractC0712a {

    /* renamed from: e */
    public boolean f11692e;

    /* renamed from: f */
    public UUID f11693f;

    /* renamed from: g */
    public byte[] f11694g;

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: b */
    public final Object mo2834b() {
        UUID uuid = this.f11693f;
        byte[] buildPsshAtom = PsshAtomUtil.buildPsshAtom(uuid, this.f11694g);
        byte[] bArr = this.f11694g;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i += 2) {
            sb.append((char) bArr[i]);
        }
        String sb2 = sb.toString();
        byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
        byte b = decode[0];
        decode[0] = decode[3];
        decode[3] = b;
        byte b2 = decode[1];
        decode[1] = decode[2];
        decode[2] = b2;
        byte b3 = decode[4];
        decode[4] = decode[5];
        decode[5] = b3;
        byte b4 = decode[6];
        decode[6] = decode[7];
        decode[7] = b4;
        return new SsManifest.ProtectionElement(uuid, buildPsshAtom, new TrackEncryptionBox[]{new TrackEncryptionBox(true, null, 8, decode, 0, 0, null)});
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: d */
    public final boolean mo2836d(String str) {
        return "ProtectionHeader".equals(str);
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: f */
    public final void mo2838f(XmlPullParser xmlPullParser) {
        if ("ProtectionHeader".equals(xmlPullParser.getName())) {
            this.f11692e = false;
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: j */
    public final void mo2839j(XmlPullParser xmlPullParser) {
        if ("ProtectionHeader".equals(xmlPullParser.getName())) {
            this.f11692e = true;
            String attributeValue = xmlPullParser.getAttributeValue(null, "SystemID");
            if (attributeValue.charAt(0) == '{' && attributeValue.charAt(attributeValue.length() - 1) == '}') {
                attributeValue = attributeValue.substring(1, attributeValue.length() - 1);
            }
            this.f11693f = UUID.fromString(attributeValue);
        }
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.AbstractC0712a
    /* renamed from: k */
    public final void mo2840k(XmlPullParser xmlPullParser) {
        if (this.f11692e) {
            this.f11694g = Base64.decode(xmlPullParser.getText(), 0);
        }
    }
}
