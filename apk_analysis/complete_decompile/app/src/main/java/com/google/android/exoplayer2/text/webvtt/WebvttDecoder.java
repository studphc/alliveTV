package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.regex.Matcher;
import p000.d53;
import p000.y43;

/* loaded from: classes.dex */
public final class WebvttDecoder extends SimpleSubtitleDecoder {

    /* renamed from: o */
    public final ParsableByteArray f11858o;

    /* renamed from: p */
    public final y43 f11859p;

    public WebvttDecoder() {
        super("WebvttDecoder");
        this.f11858o = new ParsableByteArray();
        this.f11859p = new y43();
    }

    /* JADX WARN: Code restructure failed: missing block: B:193:0x011c, code lost:
    
        r2 = r0;
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0388, code lost:
    
        r6.addAll(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x010d, code lost:
    
        if (")".equals(p000.y43.m8218b(r8, r9)) == false) goto L35;
     */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        WebvttCueInfo parseCue;
        String str;
        int i4;
        int i5;
        String sb;
        int i6;
        char c;
        int i7;
        boolean z2;
        WebvttDecoder webvttDecoder = this;
        int i8 = 2;
        int i9 = 0;
        int i10 = -1;
        int i11 = 1;
        ParsableByteArray parsableByteArray = webvttDecoder.f11858o;
        parsableByteArray.reset(bArr, i);
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.validateWebvttHeaderLine(parsableByteArray);
            do {
            } while (!TextUtils.isEmpty(parsableByteArray.readLine()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int i12 = i9;
                int i13 = i10;
                while (i13 == i10) {
                    i12 = parsableByteArray.getPosition();
                    String readLine = parsableByteArray.readLine();
                    if (readLine == null) {
                        i13 = i9;
                    } else if ("STYLE".equals(readLine)) {
                        i13 = i8;
                    } else if (readLine.startsWith("NOTE")) {
                        i13 = i11;
                    } else {
                        i13 = 3;
                    }
                }
                parsableByteArray.setPosition(i12);
                if (i13 != 0) {
                    if (i13 == i11) {
                        do {
                        } while (!TextUtils.isEmpty(parsableByteArray.readLine()));
                    } else {
                        if (i13 == i8) {
                            if (arrayList2.isEmpty()) {
                                parsableByteArray.readLine();
                                y43 y43Var = webvttDecoder.f11859p;
                                StringBuilder sb2 = y43Var.f28842b;
                                sb2.setLength(i9);
                                int position = parsableByteArray.getPosition();
                                do {
                                } while (!TextUtils.isEmpty(parsableByteArray.readLine()));
                                byte[] data = parsableByteArray.getData();
                                int position2 = parsableByteArray.getPosition();
                                ParsableByteArray parsableByteArray2 = y43Var.f28841a;
                                parsableByteArray2.reset(data, position2);
                                parsableByteArray2.setPosition(position);
                                ArrayList arrayList3 = new ArrayList();
                                while (true) {
                                    y43.m8219c(parsableByteArray2);
                                    if (parsableByteArray2.bytesLeft() >= 5 && "::cue".equals(parsableByteArray2.readString(5))) {
                                        int position3 = parsableByteArray2.getPosition();
                                        String m8218b = y43.m8218b(parsableByteArray2, sb2);
                                        if (m8218b != null) {
                                            if ("{".equals(m8218b)) {
                                                parsableByteArray2.setPosition(position3);
                                                str = "";
                                            } else if ("(".equals(m8218b)) {
                                                int position4 = parsableByteArray2.getPosition();
                                                int limit = parsableByteArray2.limit();
                                                int i14 = i9;
                                                while (position4 < limit && i14 == 0) {
                                                    int i15 = position4 + 1;
                                                    if (((char) parsableByteArray2.getData()[position4]) == ')') {
                                                        i14 = i11;
                                                    } else {
                                                        i14 = i9;
                                                    }
                                                    position4 = i15;
                                                }
                                                str = parsableByteArray2.readString((position4 + i10) - parsableByteArray2.getPosition()).trim();
                                            } else {
                                                str = null;
                                            }
                                            if (str == null && "{".equals(y43.m8218b(parsableByteArray2, sb2))) {
                                                WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
                                                if (!"".equals(str)) {
                                                    int indexOf = str.indexOf(91);
                                                    if (indexOf != i10) {
                                                        Matcher matcher = y43.f28839c.matcher(str.substring(indexOf));
                                                        if (matcher.matches()) {
                                                            webvttCssStyle.setTargetVoice((String) Assertions.checkNotNull(matcher.group(i11)));
                                                        }
                                                        str = str.substring(i9, indexOf);
                                                    }
                                                    String[] split = Util.split(str, "\\.");
                                                    String str2 = split[i9];
                                                    int indexOf2 = str2.indexOf(35);
                                                    if (indexOf2 != i10) {
                                                        webvttCssStyle.setTargetTagName(str2.substring(i9, indexOf2));
                                                        webvttCssStyle.setTargetId(str2.substring(indexOf2 + i11));
                                                    } else {
                                                        webvttCssStyle.setTargetTagName(str2);
                                                    }
                                                    if (split.length > i11) {
                                                        webvttCssStyle.setTargetClasses((String[]) Util.nullSafeArrayCopyOfRange(split, i11, split.length));
                                                    }
                                                }
                                                int i16 = i9;
                                                String str3 = null;
                                                while (i16 == 0) {
                                                    int position5 = parsableByteArray2.getPosition();
                                                    str3 = y43.m8218b(parsableByteArray2, sb2);
                                                    if (str3 != null && !"}".equals(str3)) {
                                                        i4 = i9;
                                                    } else {
                                                        i4 = i11;
                                                    }
                                                    if (i4 == 0) {
                                                        parsableByteArray2.setPosition(position5);
                                                        y43.m8219c(parsableByteArray2);
                                                        String m8217a = y43.m8217a(parsableByteArray2, sb2);
                                                        if (!"".equals(m8217a) && ":".equals(y43.m8218b(parsableByteArray2, sb2))) {
                                                            y43.m8219c(parsableByteArray2);
                                                            StringBuilder sb3 = new StringBuilder();
                                                            boolean z3 = false;
                                                            while (true) {
                                                                if (!z3) {
                                                                    int position6 = parsableByteArray2.getPosition();
                                                                    boolean z4 = z3;
                                                                    String m8218b2 = y43.m8218b(parsableByteArray2, sb2);
                                                                    if (m8218b2 == null) {
                                                                        sb = null;
                                                                    } else if (!"}".equals(m8218b2) && !";".equals(m8218b2)) {
                                                                        sb3.append(m8218b2);
                                                                        z3 = z4;
                                                                    } else {
                                                                        parsableByteArray2.setPosition(position6);
                                                                        z3 = true;
                                                                    }
                                                                } else {
                                                                    sb = sb3.toString();
                                                                }
                                                            }
                                                            if (sb != null && !"".equals(sb)) {
                                                                int position7 = parsableByteArray2.getPosition();
                                                                String m8218b3 = y43.m8218b(parsableByteArray2, sb2);
                                                                if (!";".equals(m8218b3)) {
                                                                    if ("}".equals(m8218b3)) {
                                                                        parsableByteArray2.setPosition(position7);
                                                                    }
                                                                }
                                                                if (TypedValues.Custom.S_COLOR.equals(m8217a)) {
                                                                    webvttCssStyle.setFontColor(ColorParser.parseCssColor(sb));
                                                                } else if ("background-color".equals(m8217a)) {
                                                                    webvttCssStyle.setBackgroundColor(ColorParser.parseCssColor(sb));
                                                                } else {
                                                                    if ("ruby-position".equals(m8217a)) {
                                                                        if ("over".equals(sb)) {
                                                                            i7 = 1;
                                                                            webvttCssStyle.setRubyPosition(1);
                                                                            i5 = i7;
                                                                        } else if ("under".equals(sb)) {
                                                                            webvttCssStyle.setRubyPosition(2);
                                                                            i5 = 1;
                                                                            i11 = i5;
                                                                            i16 = i4;
                                                                            i9 = 0;
                                                                        }
                                                                    } else if ("text-combine-upright".equals(m8217a)) {
                                                                        if (!"all".equals(sb) && !sb.startsWith("digits")) {
                                                                            z2 = false;
                                                                        } else {
                                                                            z2 = true;
                                                                        }
                                                                        webvttCssStyle.setCombineUpright(z2);
                                                                    } else if ("text-decoration".equals(m8217a)) {
                                                                        if ("underline".equals(sb)) {
                                                                            i7 = 1;
                                                                            webvttCssStyle.setUnderline(true);
                                                                            i5 = i7;
                                                                        }
                                                                    } else if ("font-family".equals(m8217a)) {
                                                                        webvttCssStyle.setFontFamily(sb);
                                                                    } else if ("font-weight".equals(m8217a)) {
                                                                        if ("bold".equals(sb)) {
                                                                            i6 = 1;
                                                                            webvttCssStyle.setBold(true);
                                                                            i5 = i6;
                                                                        }
                                                                    } else {
                                                                        i6 = 1;
                                                                        if ("font-style".equals(m8217a)) {
                                                                            if ("italic".equals(sb)) {
                                                                                webvttCssStyle.setItalic(true);
                                                                            }
                                                                            i5 = i6;
                                                                        } else if ("font-size".equals(m8217a)) {
                                                                            Matcher matcher2 = y43.f28840d.matcher(Ascii.toLowerCase(sb));
                                                                            if (!matcher2.matches()) {
                                                                                Log.m3027w("WebvttCssParser", "Invalid font-size: '" + sb + "'.");
                                                                            } else {
                                                                                String str4 = (String) Assertions.checkNotNull(matcher2.group(2));
                                                                                str4.getClass();
                                                                                switch (str4.hashCode()) {
                                                                                    case 37:
                                                                                        if (str4.equals("%")) {
                                                                                            c = 0;
                                                                                            break;
                                                                                        }
                                                                                        break;
                                                                                    case 3240:
                                                                                        if (str4.equals("em")) {
                                                                                            c = 1;
                                                                                            break;
                                                                                        }
                                                                                        break;
                                                                                    case 3592:
                                                                                        if (str4.equals("px")) {
                                                                                            c = 2;
                                                                                            break;
                                                                                        }
                                                                                        break;
                                                                                }
                                                                                c = 65535;
                                                                                switch (c) {
                                                                                    case 0:
                                                                                        i5 = 1;
                                                                                        webvttCssStyle.setFontSizeUnit(3);
                                                                                        break;
                                                                                    case 1:
                                                                                        i5 = 1;
                                                                                        webvttCssStyle.setFontSizeUnit(2);
                                                                                        break;
                                                                                    case 2:
                                                                                        i5 = 1;
                                                                                        webvttCssStyle.setFontSizeUnit(1);
                                                                                        break;
                                                                                    default:
                                                                                        throw new IllegalStateException();
                                                                                }
                                                                                webvttCssStyle.setFontSize(Float.parseFloat((String) Assertions.checkNotNull(matcher2.group(i5))));
                                                                                i11 = i5;
                                                                                i16 = i4;
                                                                                i9 = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                    i11 = i5;
                                                                    i16 = i4;
                                                                    i9 = 0;
                                                                }
                                                            }
                                                            i5 = 1;
                                                            i11 = i5;
                                                            i16 = i4;
                                                            i9 = 0;
                                                        }
                                                    }
                                                    i5 = i11;
                                                    i11 = i5;
                                                    i16 = i4;
                                                    i9 = 0;
                                                }
                                                int i17 = i11;
                                                if ("}".equals(str3)) {
                                                    arrayList3.add(webvttCssStyle);
                                                }
                                                i11 = i17;
                                                i8 = 2;
                                                i9 = 0;
                                                i10 = -1;
                                            }
                                        }
                                    }
                                    str = null;
                                    if (str == null) {
                                    }
                                }
                            } else {
                                throw new SubtitleDecoderException("A style block was found after the first cue.");
                            }
                        } else {
                            i2 = i8;
                            i3 = i11;
                            if (i13 == 3 && (parseCue = WebvttCueParser.parseCue(parsableByteArray, arrayList)) != null) {
                                arrayList2.add(parseCue);
                            }
                        }
                        i11 = i3;
                        i8 = i2;
                        i9 = 0;
                        i10 = -1;
                        webvttDecoder = this;
                    }
                } else {
                    return new d53(arrayList2);
                }
            }
        } catch (ParserException e) {
            throw new SubtitleDecoderException(e);
        }
    }
}
