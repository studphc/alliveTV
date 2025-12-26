package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000.AbstractC1726qj;
import p000.C1882ur;
import p000.dl1;
import p000.ee0;
import p000.el1;
import p000.wd0;
import p000.y00;
import p000.ye0;

@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class MediaCodecUtil {

    /* renamed from: a */
    public static final Pattern f10723a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b */
    public static final HashMap f10724b = new HashMap();

    /* renamed from: c */
    public static int f10725c = -1;

    /* loaded from: classes.dex */
    public static class DecoderQueryException extends Exception {
    }

    /* renamed from: a */
    public static void m2662a(String str, ArrayList arrayList) {
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            if (Util.SDK_INT < 26 && Util.DEVICE.equals("R9") && arrayList.size() == 1 && ((MediaCodecInfo) arrayList.get(0)).name.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayList.add(MediaCodecInfo.newInstance("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false, false));
            }
            Collections.sort(arrayList, new C1882ur(1, new ee0(9)));
        }
        int i = Util.SDK_INT;
        if (i < 21 && arrayList.size() > 1) {
            String str2 = ((MediaCodecInfo) arrayList.get(0)).name;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                Collections.sort(arrayList, new C1882ur(1, new ee0(10)));
            }
        }
        if (i < 32 && arrayList.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((MediaCodecInfo) arrayList.get(0)).name)) {
            arrayList.add((MediaCodecInfo) arrayList.remove(0));
        }
    }

    /* renamed from: b */
    public static String m2663b(android.media.MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals(MimeTypes.VIDEO_DOLBY_VISION)) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals(MimeTypes.AUDIO_FLAC) && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals(MimeTypes.AUDIO_AC3) && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
    
        if (r8 != false) goto L9;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList m2664c(dl1 dl1Var, el1 el1Var) {
        String m2663b;
        String str;
        String str2;
        int i;
        boolean z;
        int i2;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean mo4724f;
        boolean mo4725k;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean isHardwareAccelerated;
        boolean isAlias;
        dl1 dl1Var2 = dl1Var;
        el1 el1Var2 = el1Var;
        try {
            ArrayList arrayList = new ArrayList();
            String str3 = dl1Var2.f16408a;
            int mo4726l = el1Var.mo4726l();
            boolean mo4727p = el1Var.mo4727p();
            int i3 = 0;
            while (i3 < mo4726l) {
                android.media.MediaCodecInfo mo4723a = el1Var2.mo4723a(i3);
                int i4 = Util.SDK_INT;
                if (i4 >= 29) {
                    isAlias = mo4723a.isAlias();
                }
                String name = mo4723a.getName();
                if (m2665d(mo4723a, name, mo4727p, str3) && (m2663b = m2663b(mo4723a, name, str3)) != null) {
                    try {
                        capabilitiesForType = mo4723a.getCapabilitiesForType(m2663b);
                        mo4724f = el1Var2.mo4724f("tunneled-playback", m2663b, capabilitiesForType);
                        mo4725k = el1Var2.mo4725k("tunneled-playback", capabilitiesForType);
                        z2 = dl1Var2.f16410c;
                    } catch (Exception e) {
                        e = e;
                        str = m2663b;
                        str2 = name;
                        i = i3;
                        z = mo4727p;
                        i2 = mo4726l;
                    }
                    if ((z2 || !mo4725k) && (!z2 || mo4724f)) {
                        boolean mo4724f2 = el1Var2.mo4724f("secure-playback", m2663b, capabilitiesForType);
                        boolean mo4725k2 = el1Var2.mo4725k("secure-playback", capabilitiesForType);
                        boolean z7 = dl1Var2.f16409b;
                        if ((z7 || !mo4725k2) && (!z7 || mo4724f2)) {
                            if (i4 >= 29) {
                                isHardwareAccelerated = mo4723a.isHardwareAccelerated();
                                z4 = isHardwareAccelerated;
                                z3 = true;
                            } else {
                                z3 = true;
                                z4 = !m2666e(mo4723a, str3);
                            }
                            boolean m2666e = m2666e(mo4723a, str3);
                            if (i4 >= 29) {
                                z6 = mo4723a.isVendor();
                            } else {
                                String lowerCase = Ascii.toLowerCase(mo4723a.getName());
                                if (!lowerCase.startsWith("omx.google.") && !lowerCase.startsWith("c2.android.") && !lowerCase.startsWith("c2.google.")) {
                                    z5 = z3;
                                } else {
                                    z5 = false;
                                }
                                z6 = z5;
                            }
                            if ((mo4727p && z7 == mo4724f2) || (!mo4727p && !z7)) {
                                str = m2663b;
                                i = i3;
                                z = mo4727p;
                                i2 = mo4726l;
                                try {
                                    arrayList.add(MediaCodecInfo.newInstance(name, str3, m2663b, capabilitiesForType, z4, m2666e, z6, false, false));
                                } catch (Exception e2) {
                                    e = e2;
                                    str2 = name;
                                    if (Util.SDK_INT > 23) {
                                    }
                                    Log.m3023e("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                    throw e;
                                }
                            } else {
                                str = m2663b;
                                i = i3;
                                z = mo4727p;
                                i2 = mo4726l;
                                if (!z && mo4724f2) {
                                    StringBuilder sb = new StringBuilder();
                                    try {
                                        sb.append(name);
                                        sb.append(".secure");
                                        str2 = name;
                                    } catch (Exception e3) {
                                        e = e3;
                                        str2 = name;
                                    }
                                    try {
                                        arrayList.add(MediaCodecInfo.newInstance(sb.toString(), str3, str, capabilitiesForType, z4, m2666e, z6, false, true));
                                        return arrayList;
                                    } catch (Exception e4) {
                                        e = e4;
                                        if (Util.SDK_INT > 23 && !arrayList.isEmpty()) {
                                            Log.m3023e("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
                                            i3 = i + 1;
                                            dl1Var2 = dl1Var;
                                            mo4726l = i2;
                                            mo4727p = z;
                                            el1Var2 = el1Var;
                                        } else {
                                            Log.m3023e("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                            throw e;
                                        }
                                    }
                                }
                            }
                            i3 = i + 1;
                            dl1Var2 = dl1Var;
                            mo4726l = i2;
                            mo4727p = z;
                            el1Var2 = el1Var;
                        }
                    }
                }
                i = i3;
                z = mo4727p;
                i2 = mo4726l;
                i3 = i + 1;
                dl1Var2 = dl1Var;
                mo4726l = i2;
                mo4727p = z;
                el1Var2 = el1Var;
            }
            return arrayList;
        } catch (Exception e5) {
            throw new Exception("Failed to query underlying media codecs", e5);
        }
    }

    @VisibleForTesting
    public static synchronized void clearDecoderInfoCache() {
        synchronized (MediaCodecUtil.class) {
            f10724b.clear();
        }
    }

    /* renamed from: d */
    public static boolean m2665d(android.media.MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i = Util.SDK_INT;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = Util.DEVICE;
            if ("a70".equals(str3) || ("Xiaomi".equals(Util.MANUFACTURER) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = Util.DEVICE;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = Util.DEVICE;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Util.MANUFACTURER))) {
            String str6 = Util.DEVICE;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util.MANUFACTURER)) {
            String str7 = Util.DEVICE;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        if (i <= 23 && MimeTypes.AUDIO_E_AC3_JOC.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public static boolean m2666e(android.media.MediaCodecInfo mediaCodecInfo, String str) {
        boolean isSoftwareOnly;
        if (Util.SDK_INT >= 29) {
            isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
            return isSoftwareOnly;
        }
        if (MimeTypes.isAudio(str)) {
            return true;
        }
        String lowerCase = Ascii.toLowerCase(mediaCodecInfo.getName());
        if (lowerCase.startsWith("arc.")) {
            return false;
        }
        if (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.")) {
            return true;
        }
        if (!lowerCase.startsWith("omx.") && !lowerCase.startsWith("c2.")) {
            return true;
        }
        return false;
    }

    @Nullable
    public static String getAlternativeCodecMimeType(Format format) {
        Pair<Integer, Integer> codecProfileAndLevel;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(format.sampleMimeType)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) && (codecProfileAndLevel = getCodecProfileAndLevel(format)) != null) {
            int intValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (intValue != 16 && intValue != 256) {
                if (intValue == 512) {
                    return MimeTypes.VIDEO_H264;
                }
                return null;
            }
            return MimeTypes.VIDEO_H265;
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0494, code lost:
    
        if (r2.equals("H123") == false) goto L290;
     */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x037a A[Catch: NumberFormatException -> 0x038b, TRY_LEAVE, TryCatch #3 {NumberFormatException -> 0x038b, blocks: (B:203:0x032f, B:205:0x0341, B:217:0x0360, B:220:0x037a), top: B:202:0x032f }] */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05dc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0669  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> getCodecProfileAndLevel(Format format) {
        char c;
        int i;
        int i2;
        int i3;
        int parseInt;
        int parseInt2;
        int i4;
        int i5;
        int i6;
        int i7;
        char c2;
        Integer num;
        int i8;
        int i9;
        int i10;
        char c3;
        char c4;
        Integer num2;
        int i11;
        char c5;
        Integer num3;
        Pattern pattern = f10723a;
        int i12 = 16;
        int i13 = 4;
        String str = format.codecs;
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType)) {
            String str2 = format.codecs;
            if (split.length < 3) {
                ye0.m8279B("Ignoring malformed Dolby Vision codec string: ", str2, "MediaCodecUtil");
                return null;
            }
            Matcher matcher = pattern.matcher(split[1]);
            if (!matcher.matches()) {
                ye0.m8279B("Ignoring malformed Dolby Vision codec string: ", str2, "MediaCodecUtil");
                return null;
            }
            String group = matcher.group(1);
            if (group != null) {
                switch (group.hashCode()) {
                    case 1536:
                        if (group.equals("00")) {
                            c3 = 0;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1537:
                        if (group.equals("01")) {
                            c3 = 1;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1538:
                        if (group.equals("02")) {
                            c3 = 2;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1539:
                        if (group.equals("03")) {
                            c3 = 3;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1540:
                        if (group.equals("04")) {
                            c3 = 4;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1541:
                        if (group.equals("05")) {
                            c3 = 5;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1542:
                        if (group.equals("06")) {
                            c3 = 6;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1543:
                        if (group.equals("07")) {
                            c3 = 7;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1544:
                        if (group.equals("08")) {
                            c3 = '\b';
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1545:
                        if (group.equals("09")) {
                            c3 = '\t';
                            break;
                        }
                        c3 = 65535;
                        break;
                    default:
                        c3 = 65535;
                        break;
                }
                switch (c3) {
                    case 0:
                        c4 = 2;
                        num2 = 1;
                        break;
                    case 1:
                        c4 = 2;
                        num2 = 2;
                        break;
                    case 2:
                        i11 = 4;
                        num2 = i11;
                        c4 = 2;
                        break;
                    case 3:
                        i11 = 8;
                        num2 = i11;
                        c4 = 2;
                        break;
                    case 4:
                        i11 = 16;
                        num2 = i11;
                        c4 = 2;
                        break;
                    case 5:
                        i11 = 32;
                        num2 = i11;
                        c4 = 2;
                        break;
                    case 6:
                        i11 = 64;
                        num2 = i11;
                        c4 = 2;
                        break;
                    case 7:
                        i11 = 128;
                        num2 = i11;
                        c4 = 2;
                        break;
                    case '\b':
                        i11 = 256;
                        num2 = i11;
                        c4 = 2;
                        break;
                    case '\t':
                        i11 = 512;
                        num2 = i11;
                        c4 = 2;
                        break;
                }
                if (num2 != null) {
                    ye0.m8279B("Unknown Dolby Vision profile string: ", group, "MediaCodecUtil");
                    return null;
                }
                String str3 = split[c4];
                if (str3 != null) {
                    switch (str3.hashCode()) {
                        case 1537:
                            if (str3.equals("01")) {
                                c5 = 0;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1538:
                            if (str3.equals("02")) {
                                c5 = 1;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1539:
                            if (str3.equals("03")) {
                                c5 = 2;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1540:
                            if (str3.equals("04")) {
                                c5 = 3;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1541:
                            if (str3.equals("05")) {
                                c5 = 4;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1542:
                            if (str3.equals("06")) {
                                c5 = 5;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1543:
                            if (str3.equals("07")) {
                                c5 = 6;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1544:
                            if (str3.equals("08")) {
                                c5 = 7;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1545:
                            if (str3.equals("09")) {
                                c5 = '\b';
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1567:
                            if (str3.equals("10")) {
                                c5 = '\t';
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1568:
                            if (str3.equals("11")) {
                                c5 = '\n';
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1569:
                            if (str3.equals("12")) {
                                c5 = 11;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 1570:
                            if (str3.equals("13")) {
                                c5 = '\f';
                                break;
                            }
                            c5 = 65535;
                            break;
                        default:
                            c5 = 65535;
                            break;
                    }
                    switch (c5) {
                        case 0:
                            num3 = 1;
                            break;
                        case 1:
                            num3 = 2;
                            break;
                        case 2:
                            num3 = 4;
                            break;
                        case 3:
                            num3 = 8;
                            break;
                        case 4:
                            num3 = 16;
                            break;
                        case 5:
                            num3 = 32;
                            break;
                        case 6:
                            num3 = 64;
                            break;
                        case 7:
                            num3 = 128;
                            break;
                        case '\b':
                            num3 = 256;
                            break;
                        case '\t':
                            num3 = 512;
                            break;
                        case '\n':
                            num3 = 1024;
                            break;
                        case 11:
                            num3 = 2048;
                            break;
                        case '\f':
                            num3 = 4096;
                            break;
                    }
                    if (num3 != null) {
                        ye0.m8279B("Unknown Dolby Vision level string: ", str3, "MediaCodecUtil");
                        return null;
                    }
                    return new Pair<>(num2, num3);
                }
                num3 = null;
                if (num3 != null) {
                }
            }
            num2 = null;
            c4 = 2;
            if (num2 != null) {
            }
        } else {
            String str4 = split[0];
            str4.getClass();
            switch (str4.hashCode()) {
                case 3004662:
                    if (str4.equals("av01")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3006243:
                    if (str4.equals("avc1")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3006244:
                    if (str4.equals("avc2")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3199032:
                    if (str4.equals("hev1")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3214780:
                    if (str4.equals("hvc1")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3356560:
                    if (str4.equals("mp4a")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3624515:
                    if (str4.equals("vp09")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    String str5 = format.codecs;
                    ColorInfo colorInfo = format.colorInfo;
                    if (split.length < 4) {
                        ye0.m8279B("Ignoring malformed AV1 codec string: ", str5, "MediaCodecUtil");
                        return null;
                    }
                    try {
                        int parseInt3 = Integer.parseInt(split[1]);
                        int parseInt4 = Integer.parseInt(split[2].substring(0, 2));
                        int parseInt5 = Integer.parseInt(split[3]);
                        if (parseInt3 != 0) {
                            AbstractC1726qj.m7036A(parseInt3, "Unknown AV1 profile: ", "MediaCodecUtil");
                            return null;
                        }
                        if (parseInt5 != 8 && parseInt5 != 10) {
                            AbstractC1726qj.m7036A(parseInt5, "Unknown AV1 bit depth: ", "MediaCodecUtil");
                            return null;
                        }
                        if (parseInt5 == 8) {
                            i = 1;
                        } else if (colorInfo != null && (colorInfo.hdrStaticInfo != null || (i2 = colorInfo.colorTransfer) == 7 || i2 == 6)) {
                            i = 4096;
                        } else {
                            i = 2;
                        }
                        switch (parseInt4) {
                            case 0:
                                i12 = 1;
                                i3 = -1;
                                break;
                            case 1:
                                i12 = 2;
                                i3 = -1;
                                break;
                            case 2:
                                i12 = 4;
                                i3 = -1;
                                break;
                            case 3:
                                i12 = 8;
                                i3 = -1;
                                break;
                            case 4:
                                i3 = -1;
                                break;
                            case 5:
                                i12 = 32;
                                i3 = -1;
                                break;
                            case 6:
                                i12 = 64;
                                i3 = -1;
                                break;
                            case 7:
                                i12 = 128;
                                i3 = -1;
                                break;
                            case 8:
                                i12 = 256;
                                i3 = -1;
                                break;
                            case 9:
                                i12 = 512;
                                i3 = -1;
                                break;
                            case 10:
                                i12 = 1024;
                                i3 = -1;
                                break;
                            case 11:
                                i12 = 2048;
                                i3 = -1;
                                break;
                            case 12:
                                i12 = 4096;
                                i3 = -1;
                                break;
                            case 13:
                                i3 = -1;
                                i12 = 8192;
                                break;
                            case 14:
                                i3 = -1;
                                i12 = 16384;
                                break;
                            case 15:
                                i12 = 32768;
                                i3 = -1;
                                break;
                            case 16:
                                i3 = -1;
                                i12 = 65536;
                                break;
                            case 17:
                                i12 = 131072;
                                i3 = -1;
                                break;
                            case 18:
                                i12 = 262144;
                                i3 = -1;
                                break;
                            case 19:
                                i12 = 524288;
                                i3 = -1;
                                break;
                            case 20:
                                i12 = 1048576;
                                i3 = -1;
                                break;
                            case 21:
                                i12 = 2097152;
                                i3 = -1;
                                break;
                            case 22:
                                i12 = 4194304;
                                i3 = -1;
                                break;
                            case 23:
                                i12 = 8388608;
                                i3 = -1;
                                break;
                            default:
                                i3 = -1;
                                i12 = -1;
                                break;
                        }
                        if (i12 == i3) {
                            AbstractC1726qj.m7036A(parseInt4, "Unknown AV1 level: ", "MediaCodecUtil");
                            return null;
                        }
                        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i12));
                    } catch (NumberFormatException unused) {
                        ye0.m8279B("Ignoring malformed AV1 codec string: ", str5, "MediaCodecUtil");
                        return null;
                    }
                case 1:
                case 2:
                    String str6 = format.codecs;
                    if (split.length < 2) {
                        ye0.m8279B("Ignoring malformed AVC codec string: ", str6, "MediaCodecUtil");
                        return null;
                    }
                    try {
                        if (split[1].length() == 6) {
                            parseInt = Integer.parseInt(split[1].substring(0, 2), 16);
                            parseInt2 = Integer.parseInt(split[1].substring(4), 16);
                        } else if (split.length >= 3) {
                            parseInt = Integer.parseInt(split[1]);
                            parseInt2 = Integer.parseInt(split[2]);
                        } else {
                            Log.m3027w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str6);
                            return null;
                        }
                        if (parseInt != 66) {
                            if (parseInt != 77) {
                                if (parseInt != 88) {
                                    if (parseInt != 100) {
                                        if (parseInt != 110) {
                                            if (parseInt != 122) {
                                                if (parseInt != 244) {
                                                    i5 = -1;
                                                    i4 = -1;
                                                } else {
                                                    i4 = 64;
                                                }
                                            } else {
                                                i4 = 32;
                                            }
                                        } else {
                                            i4 = 16;
                                        }
                                    } else {
                                        i4 = 8;
                                    }
                                } else {
                                    i4 = 4;
                                }
                            } else {
                                i5 = -1;
                                i4 = 2;
                            }
                            if (i4 != i5) {
                                AbstractC1726qj.m7036A(parseInt, "Unknown AVC profile: ", "MediaCodecUtil");
                                return null;
                            }
                            switch (parseInt2) {
                                case 10:
                                    i12 = 1;
                                    i6 = -1;
                                    break;
                                case 11:
                                    i12 = 4;
                                    i6 = -1;
                                    break;
                                case 12:
                                    i12 = 8;
                                    i6 = -1;
                                    break;
                                case 13:
                                    i6 = -1;
                                    break;
                                default:
                                    switch (parseInt2) {
                                        case 20:
                                            i12 = 32;
                                            i6 = -1;
                                            break;
                                        case 21:
                                            i12 = 64;
                                            i6 = -1;
                                            break;
                                        case 22:
                                            i12 = 128;
                                            i6 = -1;
                                            break;
                                        default:
                                            switch (parseInt2) {
                                                case 30:
                                                    i12 = 256;
                                                    i6 = -1;
                                                    break;
                                                case 31:
                                                    i12 = 512;
                                                    i6 = -1;
                                                    break;
                                                case 32:
                                                    i12 = 1024;
                                                    i6 = -1;
                                                    break;
                                                default:
                                                    switch (parseInt2) {
                                                        case 40:
                                                            i12 = 2048;
                                                            i6 = -1;
                                                            break;
                                                        case 41:
                                                            i12 = 4096;
                                                            i6 = -1;
                                                            break;
                                                        case 42:
                                                            i12 = 8192;
                                                            i6 = -1;
                                                            break;
                                                        default:
                                                            switch (parseInt2) {
                                                                case 50:
                                                                    i6 = -1;
                                                                    i12 = 16384;
                                                                    break;
                                                                case 51:
                                                                    i12 = 32768;
                                                                    i6 = -1;
                                                                    break;
                                                                case 52:
                                                                    i12 = 65536;
                                                                    i6 = -1;
                                                                    break;
                                                                default:
                                                                    i6 = -1;
                                                                    i12 = -1;
                                                                    break;
                                                            }
                                                    }
                                            }
                                    }
                            }
                            if (i12 == i6) {
                                AbstractC1726qj.m7036A(parseInt2, "Unknown AVC level: ", "MediaCodecUtil");
                                return null;
                            }
                            return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i12));
                        }
                        i4 = 1;
                        i5 = -1;
                        if (i4 != i5) {
                        }
                    } catch (NumberFormatException unused2) {
                        ye0.m8279B("Ignoring malformed AVC codec string: ", str6, "MediaCodecUtil");
                        return null;
                    }
                case 3:
                case 4:
                    char c6 = 11;
                    String str7 = format.codecs;
                    if (split.length < 4) {
                        ye0.m8279B("Ignoring malformed HEVC codec string: ", str7, "MediaCodecUtil");
                        return null;
                    }
                    Matcher matcher2 = pattern.matcher(split[1]);
                    if (!matcher2.matches()) {
                        ye0.m8279B("Ignoring malformed HEVC codec string: ", str7, "MediaCodecUtil");
                        return null;
                    }
                    String group2 = matcher2.group(1);
                    if (IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(group2)) {
                        i7 = 1;
                    } else if (ExifInterface.GPS_MEASUREMENT_2D.equals(group2)) {
                        i7 = 2;
                    } else {
                        ye0.m8279B("Unknown HEVC profile string: ", group2, "MediaCodecUtil");
                        return null;
                    }
                    String str8 = split[3];
                    if (str8 != null) {
                        switch (str8.hashCode()) {
                            case 70821:
                                if (str8.equals("H30")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 70914:
                                if (str8.equals("H60")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 70917:
                                if (str8.equals("H63")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 71007:
                                if (str8.equals("H90")) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 71010:
                                if (str8.equals("H93")) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 74665:
                                if (str8.equals("L30")) {
                                    c2 = 5;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 74758:
                                if (str8.equals("L60")) {
                                    c2 = 6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 74761:
                                if (str8.equals("L63")) {
                                    c2 = 7;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 74851:
                                if (str8.equals("L90")) {
                                    c2 = '\b';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 74854:
                                if (str8.equals("L93")) {
                                    c2 = '\t';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2193639:
                                if (str8.equals("H120")) {
                                    c2 = '\n';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2193642:
                                break;
                            case 2193732:
                                if (str8.equals("H150")) {
                                    c6 = '\f';
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2193735:
                                if (str8.equals("H153")) {
                                    c6 = '\r';
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2193738:
                                if (str8.equals("H156")) {
                                    c6 = 14;
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2193825:
                                if (str8.equals("H180")) {
                                    c6 = 15;
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2193828:
                                if (str8.equals("H183")) {
                                    c2 = 16;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2193831:
                                if (str8.equals("H186")) {
                                    c6 = 17;
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2312803:
                                if (str8.equals("L120")) {
                                    c6 = 18;
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2312806:
                                if (str8.equals("L123")) {
                                    c6 = 19;
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2312896:
                                if (str8.equals("L150")) {
                                    c2 = 20;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2312899:
                                if (str8.equals("L153")) {
                                    c6 = 21;
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2312902:
                                if (str8.equals("L156")) {
                                    c6 = 22;
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2312989:
                                if (str8.equals("L180")) {
                                    c6 = 23;
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2312992:
                                if (str8.equals("L183")) {
                                    c6 = 24;
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2312995:
                                if (str8.equals("L186")) {
                                    c6 = 25;
                                    c2 = c6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                                num = 2;
                                break;
                            case 1:
                                num = 8;
                                break;
                            case 2:
                                num = 32;
                                break;
                            case 3:
                                num = 128;
                                break;
                            case 4:
                                num = 512;
                                break;
                            case 5:
                                num = 1;
                                break;
                            case 6:
                                num = 4;
                                break;
                            case 7:
                                num = 16;
                                break;
                            case '\b':
                                num = 64;
                                break;
                            case '\t':
                                num = 256;
                                break;
                            case '\n':
                                num = 2048;
                                break;
                            case 11:
                                num = 8192;
                                break;
                            case '\f':
                                num = 32768;
                                break;
                            case '\r':
                                num = 131072;
                                break;
                            case 14:
                                num = 524288;
                                break;
                            case 15:
                                num = 2097152;
                                break;
                            case 16:
                                num = 8388608;
                                break;
                            case 17:
                                num = 33554432;
                                break;
                            case 18:
                                num = 1024;
                                break;
                            case 19:
                                num = 4096;
                                break;
                            case 20:
                                num = 16384;
                                break;
                            case 21:
                                num = 65536;
                                break;
                            case 22:
                                num = 262144;
                                break;
                            case 23:
                                num = 1048576;
                                break;
                            case 24:
                                num = 4194304;
                                break;
                            case 25:
                                num = 16777216;
                                break;
                        }
                        if (num != null) {
                            ye0.m8279B("Unknown HEVC level string: ", str8, "MediaCodecUtil");
                            return null;
                        }
                        return new Pair<>(Integer.valueOf(i7), num);
                    }
                    num = null;
                    if (num != null) {
                    }
                case 5:
                    String str9 = format.codecs;
                    if (split.length != 3) {
                        ye0.m8279B("Ignoring malformed MP4A codec string: ", str9, "MediaCodecUtil");
                        return null;
                    }
                    try {
                        if (!MimeTypes.AUDIO_AAC.equals(MimeTypes.getMimeTypeFromMp4ObjectType(Integer.parseInt(split[1], 16)))) {
                            return null;
                        }
                        int parseInt6 = Integer.parseInt(split[2]);
                        int i14 = 17;
                        if (parseInt6 != 17) {
                            if (parseInt6 != 20) {
                                i14 = 23;
                                if (parseInt6 != 23) {
                                    i14 = 29;
                                    if (parseInt6 != 29) {
                                        i14 = 39;
                                        if (parseInt6 != 39) {
                                            i14 = 42;
                                            if (parseInt6 != 42) {
                                                switch (parseInt6) {
                                                    case 1:
                                                        i13 = 1;
                                                        break;
                                                    case 2:
                                                        i8 = -1;
                                                        i13 = 2;
                                                        break;
                                                    case 3:
                                                        i13 = 3;
                                                        break;
                                                    case 4:
                                                        break;
                                                    case 5:
                                                        i13 = 5;
                                                        break;
                                                    case 6:
                                                        i8 = -1;
                                                        i13 = 6;
                                                        break;
                                                    default:
                                                        i8 = -1;
                                                        i13 = -1;
                                                        break;
                                                }
                                                if (i13 == i8) {
                                                    return null;
                                                }
                                                return new Pair<>(Integer.valueOf(i13), 0);
                                            }
                                        }
                                    }
                                }
                            } else {
                                i13 = 20;
                            }
                            i8 = -1;
                            if (i13 == i8) {
                            }
                        }
                        i13 = i14;
                        i8 = -1;
                        if (i13 == i8) {
                        }
                    } catch (NumberFormatException unused3) {
                        ye0.m8279B("Ignoring malformed MP4A codec string: ", str9, "MediaCodecUtil");
                        return null;
                    }
                case 6:
                    String str10 = format.codecs;
                    if (split.length < 3) {
                        ye0.m8279B("Ignoring malformed VP9 codec string: ", str10, "MediaCodecUtil");
                        return null;
                    }
                    try {
                        int parseInt7 = Integer.parseInt(split[1]);
                        int parseInt8 = Integer.parseInt(split[2]);
                        if (parseInt7 != 0) {
                            if (parseInt7 != 1) {
                                if (parseInt7 != 2) {
                                    if (parseInt7 != 3) {
                                        i9 = -1;
                                    } else {
                                        i9 = 8;
                                    }
                                } else {
                                    i9 = 4;
                                }
                            } else {
                                i9 = 2;
                            }
                        } else {
                            i9 = 1;
                        }
                        if (i9 == -1) {
                            AbstractC1726qj.m7036A(parseInt7, "Unknown VP9 profile: ", "MediaCodecUtil");
                            return null;
                        }
                        if (parseInt8 != 10) {
                            if (parseInt8 != 11) {
                                if (parseInt8 != 20) {
                                    if (parseInt8 != 21) {
                                        if (parseInt8 != 30) {
                                            if (parseInt8 != 31) {
                                                if (parseInt8 != 40) {
                                                    if (parseInt8 != 41) {
                                                        if (parseInt8 != 50) {
                                                            if (parseInt8 != 51) {
                                                                switch (parseInt8) {
                                                                    case 60:
                                                                        i12 = 2048;
                                                                        break;
                                                                    case 61:
                                                                        i12 = 4096;
                                                                        break;
                                                                    case 62:
                                                                        i12 = 8192;
                                                                        break;
                                                                    default:
                                                                        i10 = -1;
                                                                        i12 = -1;
                                                                        break;
                                                                }
                                                            } else {
                                                                i12 = 512;
                                                            }
                                                        } else {
                                                            i12 = 256;
                                                        }
                                                    } else {
                                                        i12 = 128;
                                                    }
                                                } else {
                                                    i12 = 64;
                                                }
                                            } else {
                                                i12 = 32;
                                            }
                                        }
                                    } else {
                                        i12 = 8;
                                    }
                                } else {
                                    i12 = 4;
                                }
                            } else {
                                i10 = -1;
                                i12 = 2;
                            }
                            if (i12 != i10) {
                                AbstractC1726qj.m7036A(parseInt8, "Unknown VP9 level: ", "MediaCodecUtil");
                                return null;
                            }
                            return new Pair<>(Integer.valueOf(i9), Integer.valueOf(i12));
                        }
                        i12 = 1;
                        i10 = -1;
                        if (i12 != i10) {
                        }
                    } catch (NumberFormatException unused4) {
                        ye0.m8279B("Ignoring malformed VP9 codec string: ", str10, "MediaCodecUtil");
                        return null;
                    }
                default:
                    return null;
            }
        }
    }

    @Nullable
    public static MediaCodecInfo getDecoderInfo(String str, boolean z, boolean z2) {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(str, z, z2);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [ne, java.lang.Object] */
    public static synchronized List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2) {
        wd0 wd0Var;
        int i;
        synchronized (MediaCodecUtil.class) {
            try {
                dl1 dl1Var = new dl1(str, z, z2);
                HashMap hashMap = f10724b;
                List<MediaCodecInfo> list = (List) hashMap.get(dl1Var);
                if (list != null) {
                    return list;
                }
                int i2 = Util.SDK_INT;
                if (i2 >= 21) {
                    ?? obj = new Object();
                    if (!z && !z2) {
                        i = 0;
                        obj.f23336a = i;
                        wd0Var = obj;
                    }
                    i = 1;
                    obj.f23336a = i;
                    wd0Var = obj;
                } else {
                    wd0Var = new wd0(21);
                }
                ArrayList m2664c = m2664c(dl1Var, wd0Var);
                if (z && m2664c.isEmpty() && 21 <= i2 && i2 <= 23) {
                    m2664c = m2664c(dl1Var, new wd0(21));
                    if (!m2664c.isEmpty()) {
                        Log.m3027w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((MediaCodecInfo) m2664c.get(0)).name);
                    }
                }
                m2662a(str, m2664c);
                ImmutableList copyOf = ImmutableList.copyOf((Collection) m2664c);
                hashMap.put(dl1Var, copyOf);
                return copyOf;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @CheckResult
    public static List<MediaCodecInfo> getDecoderInfosSortedByFormatSupport(List<MediaCodecInfo> list, Format format) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new C1882ur(1, new y00(format)));
        return arrayList;
    }

    @Nullable
    public static MediaCodecInfo getDecryptOnlyDecoderInfo() {
        return getDecoderInfo(MimeTypes.AUDIO_RAW, false, false);
    }

    public static int maxH264DecodableFrameSize() {
        int i;
        int i2;
        if (f10725c == -1) {
            int i3 = 0;
            MediaCodecInfo decoderInfo = getDecoderInfo(MimeTypes.VIDEO_H264, false, false);
            if (decoderInfo != null) {
                MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int i4 = 0;
                while (i3 < length) {
                    int i5 = profileLevels[i3].level;
                    if (i5 != 1 && i5 != 2) {
                        switch (i5) {
                            case 8:
                            case 16:
                            case 32:
                                i2 = 101376;
                                break;
                            case 64:
                                i2 = 202752;
                                break;
                            case 128:
                            case 256:
                                i2 = 414720;
                                break;
                            case 512:
                                i2 = 921600;
                                break;
                            case 1024:
                                i2 = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i2 = 2097152;
                                break;
                            case 8192:
                                i2 = 2228224;
                                break;
                            case 16384:
                                i2 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i2 = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i2 = 35651584;
                                break;
                            default:
                                i2 = -1;
                                break;
                        }
                    } else {
                        i2 = 25344;
                    }
                    i4 = Math.max(i2, i4);
                    i3++;
                }
                if (Util.SDK_INT >= 21) {
                    i = 345600;
                } else {
                    i = 172800;
                }
                i3 = Math.max(i4, i);
            }
            f10725c = i3;
        }
        return f10725c;
    }

    public static void warmDecoderInfoCache(String str, boolean z, boolean z2) {
        try {
            getDecoderInfos(str, z, z2);
        } catch (DecoderQueryException e) {
            Log.m3024e("MediaCodecUtil", "Codec warming failed", e);
        }
    }
}
