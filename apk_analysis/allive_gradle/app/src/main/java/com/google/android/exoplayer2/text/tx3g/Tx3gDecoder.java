package com.google.android.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import java.util.List;
import p000.jx2;
import p000.ye0;

/* loaded from: classes.dex */
public final class Tx3gDecoder extends SimpleSubtitleDecoder {

    /* renamed from: o */
    public final ParsableByteArray f11830o;

    /* renamed from: p */
    public final boolean f11831p;

    /* renamed from: q */
    public final int f11832q;

    /* renamed from: r */
    public final int f11833r;

    /* renamed from: s */
    public final String f11834s;

    /* renamed from: t */
    public final float f11835t;

    /* renamed from: u */
    public final int f11836u;

    public Tx3gDecoder(List<byte[]> list) {
        super("Tx3gDecoder");
        this.f11830o = new ParsableByteArray();
        int size = list.size();
        String str = C0643C.SANS_SERIF_NAME;
        if (size == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.f11832q = bArr[24];
            this.f11833r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.f11834s = "Serif".equals(Util.fromUtf8Bytes(bArr, 43, bArr.length - 43)) ? C0643C.SERIF_NAME : str;
            int i = bArr[25] * Ascii.DC4;
            this.f11836u = i;
            boolean z = (bArr[0] & 32) != 0;
            this.f11831p = z;
            if (z) {
                this.f11835t = Util.constrainValue(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, RecyclerView.f7068F0, 0.95f);
                return;
            } else {
                this.f11835t = 0.85f;
                return;
            }
        }
        this.f11832q = 0;
        this.f11833r = -1;
        this.f11834s = C0643C.SANS_SERIF_NAME;
        this.f11831p = false;
        this.f11835t = 0.85f;
        this.f11836u = -1;
    }

    /* renamed from: b */
    public static void m2865b(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    /* renamed from: c */
    public static void m2866c(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        boolean z;
        boolean z2;
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z3 = true;
            if ((i & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            if ((i & 4) == 0) {
                z3 = false;
            }
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (!z3 && !z && !z2) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        String readString;
        char peekChar;
        int i2;
        int i3;
        ParsableByteArray parsableByteArray = this.f11830o;
        parsableByteArray.reset(bArr, i);
        int i4 = 2;
        if (parsableByteArray.bytesLeft() >= 2) {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            if (readUnsignedShort == 0) {
                readString = "";
            } else if (parsableByteArray.bytesLeft() >= 2 && ((peekChar = parsableByteArray.peekChar()) == 65279 || peekChar == 65534)) {
                readString = parsableByteArray.readString(readUnsignedShort, Charsets.UTF_16);
            } else {
                readString = parsableByteArray.readString(readUnsignedShort, Charsets.UTF_8);
            }
            if (readString.isEmpty()) {
                return jx2.f20677b;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(readString);
            m2866c(spannableStringBuilder, this.f11832q, 0, 0, spannableStringBuilder.length(), 16711680);
            m2865b(spannableStringBuilder, this.f11833r, -1, 0, spannableStringBuilder.length(), 16711680);
            int length = spannableStringBuilder.length();
            int i5 = 0;
            String str = this.f11834s;
            if (str != C0643C.SANS_SERIF_NAME) {
                spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
            }
            float f = this.f11835t;
            while (parsableByteArray.bytesLeft() >= 8) {
                int position = parsableByteArray.getPosition();
                int readInt = parsableByteArray.readInt();
                int readInt2 = parsableByteArray.readInt();
                if (readInt2 == 1937013100) {
                    if (parsableByteArray.bytesLeft() >= i4) {
                        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                        int i6 = i5;
                        while (i6 < readUnsignedShort2) {
                            if (parsableByteArray.bytesLeft() >= 12) {
                                int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                                int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                                parsableByteArray.skipBytes(i4);
                                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                                parsableByteArray.skipBytes(1);
                                int readInt3 = parsableByteArray.readInt();
                                if (readUnsignedShort4 > spannableStringBuilder.length()) {
                                    StringBuilder m8299s = ye0.m8299s(readUnsignedShort4, "Truncating styl end (", ") to cueText.length() (");
                                    m8299s.append(spannableStringBuilder.length());
                                    m8299s.append(").");
                                    Log.m3027w("Tx3gDecoder", m8299s.toString());
                                    i2 = spannableStringBuilder.length();
                                } else {
                                    i2 = readUnsignedShort4;
                                }
                                if (readUnsignedShort3 >= i2) {
                                    Log.m3027w("Tx3gDecoder", "Ignoring styl with start (" + readUnsignedShort3 + ") >= end (" + i2 + ").");
                                    i3 = i6;
                                } else {
                                    int i7 = i2;
                                    i3 = i6;
                                    m2866c(spannableStringBuilder, readUnsignedByte, this.f11832q, readUnsignedShort3, i7, 0);
                                    m2865b(spannableStringBuilder, readInt3, this.f11833r, readUnsignedShort3, i7, 0);
                                }
                                i6 = i3 + 1;
                                i4 = 2;
                            } else {
                                throw new SubtitleDecoderException("Unexpected subtitle format.");
                            }
                        }
                    } else {
                        throw new SubtitleDecoderException("Unexpected subtitle format.");
                    }
                } else if (readInt2 == 1952608120 && this.f11831p) {
                    i4 = 2;
                    if (parsableByteArray.bytesLeft() >= 2) {
                        f = Util.constrainValue(parsableByteArray.readUnsignedShort() / this.f11836u, RecyclerView.f7068F0, 0.95f);
                    } else {
                        throw new SubtitleDecoderException("Unexpected subtitle format.");
                    }
                } else {
                    i4 = 2;
                }
                parsableByteArray.setPosition(position + readInt);
                i5 = 0;
            }
            return new jx2(new Cue.Builder().setText(spannableStringBuilder).setLine(f, 0).setLineAnchor(0).build());
        }
        throw new SubtitleDecoderException("Unexpected subtitle format.");
    }
}
