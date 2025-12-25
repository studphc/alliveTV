package com.google.android.exoplayer2.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class SubripDecoder extends SimpleSubtitleDecoder {

    /* renamed from: q */
    public static final Pattern f11816q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: r */
    public static final Pattern f11817r = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: o */
    public final StringBuilder f11818o;

    /* renamed from: p */
    public final ArrayList f11819p;

    public SubripDecoder() {
        super("SubripDecoder");
        this.f11818o = new StringBuilder();
        this.f11819p = new ArrayList();
    }

    /* renamed from: b */
    public static long m2854b(Matcher matcher, int i) {
        long j;
        String group = matcher.group(i + 1);
        if (group != null) {
            j = Long.parseLong(group) * 3600000;
        } else {
            j = 0;
        }
        long parseLong = (Long.parseLong((String) Assertions.checkNotNull(matcher.group(i + 3))) * 1000) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(i + 2))) * 60000) + j;
        String group2 = matcher.group(i + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:165:0x025d, code lost:
    
        return new p000.om2(1, (com.google.android.exoplayer2.text.Cue[]) r2.toArray(new com.google.android.exoplayer2.text.Cue[0]), r3.toArray());
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0209  */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        String readLine;
        String str;
        ParsableByteArray parsableByteArray;
        char c;
        char c2;
        int i2;
        int positionAnchor;
        float f;
        int lineAnchor;
        Cue build;
        SubripDecoder subripDecoder = this;
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(bArr, i);
        while (true) {
            String readLine2 = parsableByteArray2.readLine();
            if (readLine2 != null) {
                if (readLine2.length() != 0) {
                    try {
                        Integer.parseInt(readLine2);
                        readLine = parsableByteArray2.readLine();
                    } catch (NumberFormatException unused) {
                        Log.m3027w("SubripDecoder", "Skipping invalid index: ".concat(readLine2));
                    }
                    if (readLine == null) {
                        Log.m3027w("SubripDecoder", "Unexpected end");
                    } else {
                        Matcher matcher = f11816q.matcher(readLine);
                        if (matcher.matches()) {
                            longArray.add(m2854b(matcher, 1));
                            longArray.add(m2854b(matcher, 6));
                            StringBuilder sb = subripDecoder.f11818o;
                            sb.setLength(0);
                            ArrayList arrayList2 = subripDecoder.f11819p;
                            arrayList2.clear();
                            for (String readLine3 = parsableByteArray2.readLine(); !TextUtils.isEmpty(readLine3); readLine3 = parsableByteArray2.readLine()) {
                                if (sb.length() > 0) {
                                    sb.append("<br>");
                                }
                                String trim = readLine3.trim();
                                StringBuilder sb2 = new StringBuilder(trim);
                                Matcher matcher2 = f11817r.matcher(trim);
                                int i3 = 0;
                                while (matcher2.find()) {
                                    String group = matcher2.group();
                                    arrayList2.add(group);
                                    int start = matcher2.start() - i3;
                                    int length = group.length();
                                    sb2.replace(start, start + length, "");
                                    i3 += length;
                                }
                                sb.append(sb2.toString());
                            }
                            Spanned fromHtml = Html.fromHtml(sb.toString());
                            int i4 = 0;
                            while (true) {
                                if (i4 < arrayList2.size()) {
                                    str = (String) arrayList2.get(i4);
                                    if (!str.matches("\\{\\\\an[1-9]\\}")) {
                                        i4++;
                                    }
                                } else {
                                    str = null;
                                }
                            }
                            Cue.Builder text = new Cue.Builder().setText(fromHtml);
                            if (str == null) {
                                build = text.build();
                                parsableByteArray = parsableByteArray2;
                            } else {
                                parsableByteArray = parsableByteArray2;
                                switch (str.hashCode()) {
                                    case -685620710:
                                        if (str.equals("{\\an1}")) {
                                            c = 0;
                                            break;
                                        }
                                        break;
                                    case -685620679:
                                        if (str.equals("{\\an2}")) {
                                            c = 6;
                                            break;
                                        }
                                        break;
                                    case -685620648:
                                        if (str.equals("{\\an3}")) {
                                            c = 3;
                                            break;
                                        }
                                        break;
                                    case -685620617:
                                        if (str.equals("{\\an4}")) {
                                            c = 1;
                                            break;
                                        }
                                        break;
                                    case -685620586:
                                        if (str.equals("{\\an5}")) {
                                            c = 7;
                                            break;
                                        }
                                        break;
                                    case -685620555:
                                        if (str.equals("{\\an6}")) {
                                            c = 4;
                                            break;
                                        }
                                        break;
                                    case -685620524:
                                        if (str.equals("{\\an7}")) {
                                            c = 2;
                                            break;
                                        }
                                        break;
                                    case -685620493:
                                        if (str.equals("{\\an8}")) {
                                            c = '\b';
                                            break;
                                        }
                                        break;
                                    case -685620462:
                                        if (str.equals("{\\an9}")) {
                                            c = 5;
                                            break;
                                        }
                                        break;
                                }
                                c = 65535;
                                if (c != 0 && c != 1 && c != 2) {
                                    if (c != 3 && c != 4 && c != 5) {
                                        text.setPositionAnchor(1);
                                    } else {
                                        text.setPositionAnchor(2);
                                    }
                                } else {
                                    text.setPositionAnchor(0);
                                }
                                switch (str.hashCode()) {
                                    case -685620710:
                                        if (str.equals("{\\an1}")) {
                                            c2 = 0;
                                            break;
                                        }
                                        break;
                                    case -685620679:
                                        if (str.equals("{\\an2}")) {
                                            c2 = 1;
                                            break;
                                        }
                                        break;
                                    case -685620648:
                                        if (str.equals("{\\an3}")) {
                                            c2 = 2;
                                            break;
                                        }
                                        break;
                                    case -685620617:
                                        if (str.equals("{\\an4}")) {
                                            c2 = 6;
                                            break;
                                        }
                                        break;
                                    case -685620586:
                                        if (str.equals("{\\an5}")) {
                                            c2 = 7;
                                            break;
                                        }
                                        break;
                                    case -685620555:
                                        if (str.equals("{\\an6}")) {
                                            c2 = '\b';
                                            break;
                                        }
                                        break;
                                    case -685620524:
                                        if (str.equals("{\\an7}")) {
                                            c2 = 3;
                                            break;
                                        }
                                        break;
                                    case -685620493:
                                        if (str.equals("{\\an8}")) {
                                            c2 = 4;
                                            break;
                                        }
                                        break;
                                    case -685620462:
                                        if (str.equals("{\\an9}")) {
                                            c2 = 5;
                                            break;
                                        }
                                        break;
                                }
                                c2 = 65535;
                                if (c2 != 0 && c2 != 1) {
                                    if (c2 != 2) {
                                        if (c2 != 3 && c2 != 4 && c2 != 5) {
                                            text.setLineAnchor(1);
                                        } else {
                                            text.setLineAnchor(0);
                                        }
                                        i2 = 2;
                                        positionAnchor = text.getPositionAnchor();
                                        float f2 = 0.08f;
                                        if (positionAnchor == 0) {
                                            if (positionAnchor != 1) {
                                                if (positionAnchor == i2) {
                                                    f = 0.92f;
                                                } else {
                                                    throw new IllegalArgumentException();
                                                }
                                            } else {
                                                f = 0.5f;
                                            }
                                        } else {
                                            f = 0.08f;
                                        }
                                        Cue.Builder position = text.setPosition(f);
                                        lineAnchor = text.getLineAnchor();
                                        if (lineAnchor != 0) {
                                            if (lineAnchor != 1) {
                                                if (lineAnchor == 2) {
                                                    f2 = 0.92f;
                                                } else {
                                                    throw new IllegalArgumentException();
                                                }
                                            } else {
                                                f2 = 0.5f;
                                            }
                                        }
                                        build = position.setLine(f2, 0).build();
                                    } else {
                                        i2 = 2;
                                    }
                                } else {
                                    i2 = 2;
                                }
                                text.setLineAnchor(i2);
                                positionAnchor = text.getPositionAnchor();
                                float f22 = 0.08f;
                                if (positionAnchor == 0) {
                                }
                                Cue.Builder position2 = text.setPosition(f);
                                lineAnchor = text.getLineAnchor();
                                if (lineAnchor != 0) {
                                }
                                build = position2.setLine(f22, 0).build();
                            }
                            arrayList.add(build);
                            arrayList.add(Cue.EMPTY);
                            subripDecoder = this;
                            parsableByteArray2 = parsableByteArray;
                        } else {
                            Log.m3027w("SubripDecoder", "Skipping invalid timing: ".concat(readLine));
                            subripDecoder = this;
                        }
                    }
                }
            }
        }
    }
}
