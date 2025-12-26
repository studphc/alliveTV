package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import p000.C1913vl;
import p000.c53;

/* loaded from: classes.dex */
public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder {

    /* renamed from: o */
    public final ParsableByteArray f11837o;

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
        this.f11837o = new ParsableByteArray();
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        Cue build;
        ParsableByteArray parsableByteArray = this.f11837o;
        parsableByteArray.reset(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.bytesLeft() > 0) {
            if (parsableByteArray.bytesLeft() >= 8) {
                int readInt = parsableByteArray.readInt();
                if (parsableByteArray.readInt() == 1987343459) {
                    int i2 = readInt - 8;
                    CharSequence charSequence = null;
                    Cue.Builder builder = null;
                    while (i2 > 0) {
                        if (i2 >= 8) {
                            int readInt2 = parsableByteArray.readInt();
                            int readInt3 = parsableByteArray.readInt();
                            int i3 = readInt2 - 8;
                            String fromUtf8Bytes = Util.fromUtf8Bytes(parsableByteArray.getData(), parsableByteArray.getPosition(), i3);
                            parsableByteArray.skipBytes(i3);
                            i2 = (i2 - 8) - i3;
                            if (readInt3 == 1937011815) {
                                c53 c53Var = new c53();
                                WebvttCueParser.m2872e(fromUtf8Bytes, c53Var);
                                builder = c53Var.m2204a();
                            } else if (readInt3 == 1885436268) {
                                charSequence = WebvttCueParser.m2873f(null, fromUtf8Bytes.trim(), Collections.emptyList());
                            }
                        } else {
                            throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
                        }
                    }
                    if (charSequence == null) {
                        charSequence = "";
                    }
                    if (builder != null) {
                        build = builder.setText(charSequence).build();
                    } else {
                        Pattern pattern = WebvttCueParser.CUE_HEADER_PATTERN;
                        c53 c53Var2 = new c53();
                        c53Var2.f8257c = charSequence;
                        build = c53Var2.m2204a().build();
                    }
                    arrayList.add(build);
                } else {
                    parsableByteArray.skipBytes(readInt - 8);
                }
            } else {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new C1913vl(arrayList);
    }
}
