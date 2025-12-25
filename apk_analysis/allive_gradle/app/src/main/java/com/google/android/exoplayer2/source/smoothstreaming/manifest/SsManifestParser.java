package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class SsManifestParser implements ParsingLoadable.Parser<SsManifest> {

    /* renamed from: a */
    public final XmlPullParserFactory f11687a;

    /* loaded from: classes.dex */
    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super(AbstractC1726qj.m7038C("Missing required field: ", str), null, true, 4);
        }
    }

    public SsManifestParser() {
        try {
            this.f11687a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public SsManifest parse(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f11687a.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (SsManifest) new C0714c(uri.toString()).m2837e(newPullParser);
        } catch (XmlPullParserException e) {
            throw ParserException.createForMalformedManifest(null, e);
        }
    }
}
