package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.hisona.allive.CardPresenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import okhttp3.internal.http.HttpStatusCodesKt;
import p000.AbstractC1721qe;

/* loaded from: classes.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;

    /* renamed from: p */
    public static DefaultBandwidthMeter f12439p;

    /* renamed from: a */
    public final ImmutableMap f12440a;

    /* renamed from: b */
    public final BandwidthMeter.EventListener.EventDispatcher f12441b;

    /* renamed from: c */
    public final SlidingPercentile f12442c;

    /* renamed from: d */
    public final Clock f12443d;

    /* renamed from: e */
    public final boolean f12444e;

    /* renamed from: f */
    public int f12445f;

    /* renamed from: g */
    public long f12446g;

    /* renamed from: h */
    public long f12447h;

    /* renamed from: i */
    public int f12448i;

    /* renamed from: j */
    public long f12449j;

    /* renamed from: k */
    public long f12450k;

    /* renamed from: l */
    public long f12451l;

    /* renamed from: m */
    public long f12452m;

    /* renamed from: n */
    public boolean f12453n;

    /* renamed from: o */
    public int f12454o;
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = ImmutableList.m3907of(4800000L, 3100000L, 2100000L, 1500000L, 800000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = ImmutableList.m3907of(1500000L, 1000000L, 730000L, 440000L, 170000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = ImmutableList.m3907of(2200000L, 1400000L, 1100000L, 910000L, 620000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = ImmutableList.m3907of(3000000L, 1900000L, 1400000L, 1000000L, 660000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA = ImmutableList.m3907of(6000000L, 4100000L, 3200000L, 1800000L, 1000000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA = ImmutableList.m3907of(2800000L, 2400000L, 1600000L, 1100000L, 950000L);

    @Deprecated
    public DefaultBandwidthMeter() {
        this(null, ImmutableMap.m3923of(), 2000, Clock.DEFAULT, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:1019:0x0ceb, code lost:
    
        if (r8.equals("AD") == false) goto L4;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] m2976a(String str) {
        char c = 0;
        str.getClass();
        switch (str.hashCode()) {
            case 2083:
                break;
            case 2084:
                if (str.equals("AE")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 2085:
                if (str.equals("AF")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2086:
                if (str.equals("AG")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 2088:
                if (str.equals("AI")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 2091:
                if (str.equals("AL")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 2092:
                if (str.equals("AM")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 2094:
                if (str.equals("AO")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 2096:
                if (str.equals("AQ")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 2097:
                if (str.equals("AR")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 2098:
                if (str.equals("AS")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 2099:
                if (str.equals("AT")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 2100:
                if (str.equals("AU")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 2102:
                if (str.equals("AW")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 2103:
                if (str.equals("AX")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 2105:
                if (str.equals("AZ")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 2111:
                if (str.equals("BA")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 2112:
                if (str.equals("BB")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 2114:
                if (str.equals("BD")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 2115:
                if (str.equals("BE")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 2116:
                if (str.equals("BF")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 2117:
                if (str.equals("BG")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 2118:
                if (str.equals("BH")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 2119:
                if (str.equals("BI")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 2120:
                if (str.equals("BJ")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 2122:
                if (str.equals("BL")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 2123:
                if (str.equals("BM")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 2124:
                if (str.equals("BN")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case 2125:
                if (str.equals("BO")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case 2127:
                if (str.equals("BQ")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case 2129:
                if (str.equals("BS")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case 2130:
                if (str.equals("BT")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case 2133:
                if (str.equals("BW")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case 2135:
                if (str.equals("BY")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case 2136:
                if (str.equals("BZ")) {
                    c = Typography.quote;
                    break;
                }
                c = 65535;
                break;
            case 2142:
                if (str.equals("CA")) {
                    c = '#';
                    break;
                }
                c = 65535;
                break;
            case 2145:
                if (str.equals("CD")) {
                    c = Typography.dollar;
                    break;
                }
                c = 65535;
                break;
            case 2147:
                if (str.equals("CF")) {
                    c = '%';
                    break;
                }
                c = 65535;
                break;
            case 2148:
                if (str.equals("CG")) {
                    c = Typography.amp;
                    break;
                }
                c = 65535;
                break;
            case 2149:
                if (str.equals("CH")) {
                    c = '\'';
                    break;
                }
                c = 65535;
                break;
            case 2150:
                if (str.equals("CI")) {
                    c = '(';
                    break;
                }
                c = 65535;
                break;
            case 2152:
                if (str.equals("CK")) {
                    c = ')';
                    break;
                }
                c = 65535;
                break;
            case 2153:
                if (str.equals("CL")) {
                    c = '*';
                    break;
                }
                c = 65535;
                break;
            case 2154:
                if (str.equals("CM")) {
                    c = '+';
                    break;
                }
                c = 65535;
                break;
            case 2155:
                if (str.equals("CN")) {
                    c = ',';
                    break;
                }
                c = 65535;
                break;
            case 2156:
                if (str.equals("CO")) {
                    c = '-';
                    break;
                }
                c = 65535;
                break;
            case 2159:
                if (str.equals("CR")) {
                    c = '.';
                    break;
                }
                c = 65535;
                break;
            case 2162:
                if (str.equals("CU")) {
                    c = '/';
                    break;
                }
                c = 65535;
                break;
            case 2163:
                if (str.equals("CV")) {
                    c = '0';
                    break;
                }
                c = 65535;
                break;
            case 2164:
                if (str.equals("CW")) {
                    c = '1';
                    break;
                }
                c = 65535;
                break;
            case 2165:
                if (str.equals("CX")) {
                    c = '2';
                    break;
                }
                c = 65535;
                break;
            case 2166:
                if (str.equals("CY")) {
                    c = '3';
                    break;
                }
                c = 65535;
                break;
            case 2167:
                if (str.equals("CZ")) {
                    c = '4';
                    break;
                }
                c = 65535;
                break;
            case 2177:
                if (str.equals("DE")) {
                    c = '5';
                    break;
                }
                c = 65535;
                break;
            case 2182:
                if (str.equals("DJ")) {
                    c = '6';
                    break;
                }
                c = 65535;
                break;
            case 2183:
                if (str.equals("DK")) {
                    c = '7';
                    break;
                }
                c = 65535;
                break;
            case 2185:
                if (str.equals("DM")) {
                    c = '8';
                    break;
                }
                c = 65535;
                break;
            case 2187:
                if (str.equals("DO")) {
                    c = '9';
                    break;
                }
                c = 65535;
                break;
            case 2198:
                if (str.equals("DZ")) {
                    c = ':';
                    break;
                }
                c = 65535;
                break;
            case 2206:
                if (str.equals("EC")) {
                    c = ';';
                    break;
                }
                c = 65535;
                break;
            case 2208:
                if (str.equals("EE")) {
                    c = Typography.less;
                    break;
                }
                c = 65535;
                break;
            case 2210:
                if (str.equals("EG")) {
                    c = '=';
                    break;
                }
                c = 65535;
                break;
            case 2221:
                if (str.equals("ER")) {
                    c = Typography.greater;
                    break;
                }
                c = 65535;
                break;
            case 2222:
                if (str.equals("ES")) {
                    c = '?';
                    break;
                }
                c = 65535;
                break;
            case 2223:
                if (str.equals("ET")) {
                    c = '@';
                    break;
                }
                c = 65535;
                break;
            case 2243:
                if (str.equals("FI")) {
                    c = 'A';
                    break;
                }
                c = 65535;
                break;
            case 2244:
                if (str.equals("FJ")) {
                    c = 'B';
                    break;
                }
                c = 65535;
                break;
            case 2245:
                if (str.equals("FK")) {
                    c = 'C';
                    break;
                }
                c = 65535;
                break;
            case 2247:
                if (str.equals("FM")) {
                    c = 'D';
                    break;
                }
                c = 65535;
                break;
            case 2249:
                if (str.equals("FO")) {
                    c = 'E';
                    break;
                }
                c = 65535;
                break;
            case 2252:
                if (str.equals("FR")) {
                    c = 'F';
                    break;
                }
                c = 65535;
                break;
            case 2266:
                if (str.equals("GA")) {
                    c = 'G';
                    break;
                }
                c = 65535;
                break;
            case 2267:
                if (str.equals("GB")) {
                    c = 'H';
                    break;
                }
                c = 65535;
                break;
            case 2269:
                if (str.equals("GD")) {
                    c = 'I';
                    break;
                }
                c = 65535;
                break;
            case 2270:
                if (str.equals("GE")) {
                    c = 'J';
                    break;
                }
                c = 65535;
                break;
            case 2271:
                if (str.equals("GF")) {
                    c = 'K';
                    break;
                }
                c = 65535;
                break;
            case 2272:
                if (str.equals("GG")) {
                    c = 'L';
                    break;
                }
                c = 65535;
                break;
            case 2273:
                if (str.equals("GH")) {
                    c = 'M';
                    break;
                }
                c = 65535;
                break;
            case 2274:
                if (str.equals("GI")) {
                    c = 'N';
                    break;
                }
                c = 65535;
                break;
            case 2277:
                if (str.equals("GL")) {
                    c = 'O';
                    break;
                }
                c = 65535;
                break;
            case 2278:
                if (str.equals("GM")) {
                    c = 'P';
                    break;
                }
                c = 65535;
                break;
            case 2279:
                if (str.equals("GN")) {
                    c = 'Q';
                    break;
                }
                c = 65535;
                break;
            case 2281:
                if (str.equals("GP")) {
                    c = 'R';
                    break;
                }
                c = 65535;
                break;
            case 2282:
                if (str.equals("GQ")) {
                    c = 'S';
                    break;
                }
                c = 65535;
                break;
            case 2283:
                if (str.equals("GR")) {
                    c = 'T';
                    break;
                }
                c = 65535;
                break;
            case 2285:
                if (str.equals("GT")) {
                    c = 'U';
                    break;
                }
                c = 65535;
                break;
            case 2286:
                if (str.equals("GU")) {
                    c = 'V';
                    break;
                }
                c = 65535;
                break;
            case 2288:
                if (str.equals("GW")) {
                    c = 'W';
                    break;
                }
                c = 65535;
                break;
            case 2290:
                if (str.equals("GY")) {
                    c = 'X';
                    break;
                }
                c = 65535;
                break;
            case 2307:
                if (str.equals("HK")) {
                    c = 'Y';
                    break;
                }
                c = 65535;
                break;
            case 2314:
                if (str.equals("HR")) {
                    c = 'Z';
                    break;
                }
                c = 65535;
                break;
            case 2316:
                if (str.equals("HT")) {
                    c = '[';
                    break;
                }
                c = 65535;
                break;
            case 2317:
                if (str.equals("HU")) {
                    c = '\\';
                    break;
                }
                c = 65535;
                break;
            case 2331:
                if (str.equals("ID")) {
                    c = ']';
                    break;
                }
                c = 65535;
                break;
            case 2332:
                if (str.equals("IE")) {
                    c = '^';
                    break;
                }
                c = 65535;
                break;
            case 2339:
                if (str.equals("IL")) {
                    c = '_';
                    break;
                }
                c = 65535;
                break;
            case 2340:
                if (str.equals("IM")) {
                    c = '`';
                    break;
                }
                c = 65535;
                break;
            case 2341:
                if (str.equals("IN")) {
                    c = 'a';
                    break;
                }
                c = 65535;
                break;
            case 2342:
                if (str.equals("IO")) {
                    c = 'b';
                    break;
                }
                c = 65535;
                break;
            case 2344:
                if (str.equals("IQ")) {
                    c = 'c';
                    break;
                }
                c = 65535;
                break;
            case 2345:
                if (str.equals("IR")) {
                    c = 'd';
                    break;
                }
                c = 65535;
                break;
            case 2346:
                if (str.equals("IS")) {
                    c = 'e';
                    break;
                }
                c = 65535;
                break;
            case 2347:
                if (str.equals("IT")) {
                    c = 'f';
                    break;
                }
                c = 65535;
                break;
            case 2363:
                if (str.equals("JE")) {
                    c = 'g';
                    break;
                }
                c = 65535;
                break;
            case 2371:
                if (str.equals("JM")) {
                    c = 'h';
                    break;
                }
                c = 65535;
                break;
            case 2373:
                if (str.equals("JO")) {
                    c = 'i';
                    break;
                }
                c = 65535;
                break;
            case 2374:
                if (str.equals("JP")) {
                    c = 'j';
                    break;
                }
                c = 65535;
                break;
            case 2394:
                if (str.equals("KE")) {
                    c = 'k';
                    break;
                }
                c = 65535;
                break;
            case 2396:
                if (str.equals("KG")) {
                    c = 'l';
                    break;
                }
                c = 65535;
                break;
            case 2397:
                if (str.equals("KH")) {
                    c = 'm';
                    break;
                }
                c = 65535;
                break;
            case 2398:
                if (str.equals("KI")) {
                    c = 'n';
                    break;
                }
                c = 65535;
                break;
            case 2402:
                if (str.equals("KM")) {
                    c = 'o';
                    break;
                }
                c = 65535;
                break;
            case 2403:
                if (str.equals("KN")) {
                    c = 'p';
                    break;
                }
                c = 65535;
                break;
            case 2405:
                if (str.equals("KP")) {
                    c = 'q';
                    break;
                }
                c = 65535;
                break;
            case 2407:
                if (str.equals("KR")) {
                    c = 'r';
                    break;
                }
                c = 65535;
                break;
            case 2412:
                if (str.equals("KW")) {
                    c = 's';
                    break;
                }
                c = 65535;
                break;
            case 2414:
                if (str.equals("KY")) {
                    c = 't';
                    break;
                }
                c = 65535;
                break;
            case 2415:
                if (str.equals("KZ")) {
                    c = 'u';
                    break;
                }
                c = 65535;
                break;
            case 2421:
                if (str.equals("LA")) {
                    c = 'v';
                    break;
                }
                c = 65535;
                break;
            case 2422:
                if (str.equals("LB")) {
                    c = 'w';
                    break;
                }
                c = 65535;
                break;
            case 2423:
                if (str.equals("LC")) {
                    c = 'x';
                    break;
                }
                c = 65535;
                break;
            case 2429:
                if (str.equals("LI")) {
                    c = 'y';
                    break;
                }
                c = 65535;
                break;
            case 2431:
                if (str.equals("LK")) {
                    c = 'z';
                    break;
                }
                c = 65535;
                break;
            case 2438:
                if (str.equals("LR")) {
                    c = '{';
                    break;
                }
                c = 65535;
                break;
            case 2439:
                if (str.equals("LS")) {
                    c = '|';
                    break;
                }
                c = 65535;
                break;
            case 2440:
                if (str.equals("LT")) {
                    c = '}';
                    break;
                }
                c = 65535;
                break;
            case 2441:
                if (str.equals("LU")) {
                    c = '~';
                    break;
                }
                c = 65535;
                break;
            case 2442:
                if (str.equals("LV")) {
                    c = Ascii.MAX;
                    break;
                }
                c = 65535;
                break;
            case 2445:
                if (str.equals("LY")) {
                    c = 128;
                    break;
                }
                c = 65535;
                break;
            case 2452:
                if (str.equals("MA")) {
                    c = 129;
                    break;
                }
                c = 65535;
                break;
            case 2454:
                if (str.equals("MC")) {
                    c = 130;
                    break;
                }
                c = 65535;
                break;
            case 2455:
                if (str.equals("MD")) {
                    c = 131;
                    break;
                }
                c = 65535;
                break;
            case 2456:
                if (str.equals("ME")) {
                    c = 132;
                    break;
                }
                c = 65535;
                break;
            case 2457:
                if (str.equals("MF")) {
                    c = 133;
                    break;
                }
                c = 65535;
                break;
            case 2458:
                if (str.equals("MG")) {
                    c = 134;
                    break;
                }
                c = 65535;
                break;
            case 2459:
                if (str.equals("MH")) {
                    c = 135;
                    break;
                }
                c = 65535;
                break;
            case 2462:
                if (str.equals("MK")) {
                    c = 136;
                    break;
                }
                c = 65535;
                break;
            case 2463:
                if (str.equals("ML")) {
                    c = 137;
                    break;
                }
                c = 65535;
                break;
            case 2464:
                if (str.equals("MM")) {
                    c = 138;
                    break;
                }
                c = 65535;
                break;
            case 2465:
                if (str.equals("MN")) {
                    c = 139;
                    break;
                }
                c = 65535;
                break;
            case 2466:
                if (str.equals("MO")) {
                    c = 140;
                    break;
                }
                c = 65535;
                break;
            case 2467:
                if (str.equals("MP")) {
                    c = 141;
                    break;
                }
                c = 65535;
                break;
            case 2468:
                if (str.equals("MQ")) {
                    c = 142;
                    break;
                }
                c = 65535;
                break;
            case 2469:
                if (str.equals("MR")) {
                    c = 143;
                    break;
                }
                c = 65535;
                break;
            case 2470:
                if (str.equals("MS")) {
                    c = 144;
                    break;
                }
                c = 65535;
                break;
            case 2471:
                if (str.equals("MT")) {
                    c = 145;
                    break;
                }
                c = 65535;
                break;
            case 2472:
                if (str.equals("MU")) {
                    c = 146;
                    break;
                }
                c = 65535;
                break;
            case 2473:
                if (str.equals("MV")) {
                    c = 147;
                    break;
                }
                c = 65535;
                break;
            case 2474:
                if (str.equals("MW")) {
                    c = 148;
                    break;
                }
                c = 65535;
                break;
            case 2475:
                if (str.equals("MX")) {
                    c = 149;
                    break;
                }
                c = 65535;
                break;
            case 2476:
                if (str.equals("MY")) {
                    c = 150;
                    break;
                }
                c = 65535;
                break;
            case 2477:
                if (str.equals("MZ")) {
                    c = 151;
                    break;
                }
                c = 65535;
                break;
            case 2483:
                if (str.equals("NA")) {
                    c = 152;
                    break;
                }
                c = 65535;
                break;
            case 2485:
                if (str.equals("NC")) {
                    c = 153;
                    break;
                }
                c = 65535;
                break;
            case 2487:
                if (str.equals("NE")) {
                    c = 154;
                    break;
                }
                c = 65535;
                break;
            case 2489:
                if (str.equals("NG")) {
                    c = 155;
                    break;
                }
                c = 65535;
                break;
            case 2491:
                if (str.equals("NI")) {
                    c = 156;
                    break;
                }
                c = 65535;
                break;
            case 2494:
                if (str.equals("NL")) {
                    c = 157;
                    break;
                }
                c = 65535;
                break;
            case 2497:
                if (str.equals("NO")) {
                    c = 158;
                    break;
                }
                c = 65535;
                break;
            case 2498:
                if (str.equals("NP")) {
                    c = 159;
                    break;
                }
                c = 65535;
                break;
            case DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS /* 2500 */:
                if (str.equals("NR")) {
                    c = Typography.nbsp;
                    break;
                }
                c = 65535;
                break;
            case 2503:
                if (str.equals("NU")) {
                    c = 161;
                    break;
                }
                c = 65535;
                break;
            case 2508:
                if (str.equals("NZ")) {
                    c = Typography.cent;
                    break;
                }
                c = 65535;
                break;
            case 2526:
                if (str.equals("OM")) {
                    c = Typography.pound;
                    break;
                }
                c = 65535;
                break;
            case 2545:
                if (str.equals("PA")) {
                    c = 164;
                    break;
                }
                c = 65535;
                break;
            case 2549:
                if (str.equals("PE")) {
                    c = 165;
                    break;
                }
                c = 65535;
                break;
            case 2550:
                if (str.equals("PF")) {
                    c = 166;
                    break;
                }
                c = 65535;
                break;
            case 2551:
                if (str.equals("PG")) {
                    c = Typography.section;
                    break;
                }
                c = 65535;
                break;
            case 2552:
                if (str.equals("PH")) {
                    c = 168;
                    break;
                }
                c = 65535;
                break;
            case 2555:
                if (str.equals("PK")) {
                    c = Typography.copyright;
                    break;
                }
                c = 65535;
                break;
            case 2556:
                if (str.equals("PL")) {
                    c = 170;
                    break;
                }
                c = 65535;
                break;
            case 2557:
                if (str.equals("PM")) {
                    c = 171;
                    break;
                }
                c = 65535;
                break;
            case 2562:
                if (str.equals("PR")) {
                    c = 172;
                    break;
                }
                c = 65535;
                break;
            case 2563:
                if (str.equals("PS")) {
                    c = 173;
                    break;
                }
                c = 65535;
                break;
            case 2564:
                if (str.equals("PT")) {
                    c = Typography.registered;
                    break;
                }
                c = 65535;
                break;
            case 2567:
                if (str.equals("PW")) {
                    c = 175;
                    break;
                }
                c = 65535;
                break;
            case 2576:
                if (str.equals("QA")) {
                    c = Typography.degree;
                    break;
                }
                c = 65535;
                break;
            case 2611:
                if (str.equals("RE")) {
                    c = Typography.plusMinus;
                    break;
                }
                c = 65535;
                break;
            case 2621:
                if (str.equals("RO")) {
                    c = 178;
                    break;
                }
                c = 65535;
                break;
            case 2625:
                if (str.equals("RS")) {
                    c = 179;
                    break;
                }
                c = 65535;
                break;
            case 2627:
                if (str.equals("RU")) {
                    c = 180;
                    break;
                }
                c = 65535;
                break;
            case 2629:
                if (str.equals("RW")) {
                    c = 181;
                    break;
                }
                c = 65535;
                break;
            case 2638:
                if (str.equals("SA")) {
                    c = Typography.paragraph;
                    break;
                }
                c = 65535;
                break;
            case 2639:
                if (str.equals("SB")) {
                    c = Typography.middleDot;
                    break;
                }
                c = 65535;
                break;
            case 2640:
                if (str.equals("SC")) {
                    c = 184;
                    break;
                }
                c = 65535;
                break;
            case 2641:
                if (str.equals("SD")) {
                    c = 185;
                    break;
                }
                c = 65535;
                break;
            case 2642:
                if (str.equals("SE")) {
                    c = 186;
                    break;
                }
                c = 65535;
                break;
            case 2644:
                if (str.equals("SG")) {
                    c = 187;
                    break;
                }
                c = 65535;
                break;
            case 2645:
                if (str.equals("SH")) {
                    c = 188;
                    break;
                }
                c = 65535;
                break;
            case 2646:
                if (str.equals("SI")) {
                    c = Typography.half;
                    break;
                }
                c = 65535;
                break;
            case 2648:
                if (str.equals("SK")) {
                    c = 190;
                    break;
                }
                c = 65535;
                break;
            case 2649:
                if (str.equals("SL")) {
                    c = 191;
                    break;
                }
                c = 65535;
                break;
            case 2650:
                if (str.equals("SM")) {
                    c = 192;
                    break;
                }
                c = 65535;
                break;
            case 2651:
                if (str.equals("SN")) {
                    c = 193;
                    break;
                }
                c = 65535;
                break;
            case 2652:
                if (str.equals("SO")) {
                    c = 194;
                    break;
                }
                c = 65535;
                break;
            case 2655:
                if (str.equals("SR")) {
                    c = 195;
                    break;
                }
                c = 65535;
                break;
            case 2656:
                if (str.equals("SS")) {
                    c = 196;
                    break;
                }
                c = 65535;
                break;
            case 2657:
                if (str.equals("ST")) {
                    c = 197;
                    break;
                }
                c = 65535;
                break;
            case 2659:
                if (str.equals("SV")) {
                    c = 198;
                    break;
                }
                c = 65535;
                break;
            case 2661:
                if (str.equals("SX")) {
                    c = 199;
                    break;
                }
                c = 65535;
                break;
            case 2662:
                if (str.equals("SY")) {
                    c = 200;
                    break;
                }
                c = 65535;
                break;
            case 2663:
                if (str.equals("SZ")) {
                    c = 201;
                    break;
                }
                c = 65535;
                break;
            case 2671:
                if (str.equals("TC")) {
                    c = 202;
                    break;
                }
                c = 65535;
                break;
            case 2672:
                if (str.equals("TD")) {
                    c = 203;
                    break;
                }
                c = 65535;
                break;
            case 2675:
                if (str.equals("TG")) {
                    c = 204;
                    break;
                }
                c = 65535;
                break;
            case 2676:
                if (str.equals("TH")) {
                    c = 205;
                    break;
                }
                c = 65535;
                break;
            case 2678:
                if (str.equals("TJ")) {
                    c = 206;
                    break;
                }
                c = 65535;
                break;
            case 2679:
                if (str.equals("TK")) {
                    c = 207;
                    break;
                }
                c = 65535;
                break;
            case 2680:
                if (str.equals("TL")) {
                    c = 208;
                    break;
                }
                c = 65535;
                break;
            case 2681:
                if (str.equals("TM")) {
                    c = 209;
                    break;
                }
                c = 65535;
                break;
            case 2682:
                if (str.equals("TN")) {
                    c = 210;
                    break;
                }
                c = 65535;
                break;
            case 2683:
                if (str.equals("TO")) {
                    c = 211;
                    break;
                }
                c = 65535;
                break;
            case 2686:
                if (str.equals("TR")) {
                    c = 212;
                    break;
                }
                c = 65535;
                break;
            case 2688:
                if (str.equals("TT")) {
                    c = 213;
                    break;
                }
                c = 65535;
                break;
            case 2690:
                if (str.equals("TV")) {
                    c = 214;
                    break;
                }
                c = 65535;
                break;
            case 2691:
                if (str.equals("TW")) {
                    c = Typography.times;
                    break;
                }
                c = 65535;
                break;
            case 2694:
                if (str.equals("TZ")) {
                    c = 216;
                    break;
                }
                c = 65535;
                break;
            case 2700:
                if (str.equals("UA")) {
                    c = 217;
                    break;
                }
                c = 65535;
                break;
            case 2706:
                if (str.equals("UG")) {
                    c = 218;
                    break;
                }
                c = 65535;
                break;
            case 2718:
                if (str.equals("US")) {
                    c = 219;
                    break;
                }
                c = 65535;
                break;
            case 2724:
                if (str.equals("UY")) {
                    c = 220;
                    break;
                }
                c = 65535;
                break;
            case 2725:
                if (str.equals("UZ")) {
                    c = 221;
                    break;
                }
                c = 65535;
                break;
            case 2731:
                if (str.equals("VA")) {
                    c = 222;
                    break;
                }
                c = 65535;
                break;
            case 2733:
                if (str.equals("VC")) {
                    c = 223;
                    break;
                }
                c = 65535;
                break;
            case 2735:
                if (str.equals("VE")) {
                    c = 224;
                    break;
                }
                c = 65535;
                break;
            case 2737:
                if (str.equals("VG")) {
                    c = 225;
                    break;
                }
                c = 65535;
                break;
            case 2739:
                if (str.equals("VI")) {
                    c = 226;
                    break;
                }
                c = 65535;
                break;
            case 2744:
                if (str.equals("VN")) {
                    c = 227;
                    break;
                }
                c = 65535;
                break;
            case 2751:
                if (str.equals("VU")) {
                    c = 228;
                    break;
                }
                c = 65535;
                break;
            case 2767:
                if (str.equals("WF")) {
                    c = 229;
                    break;
                }
                c = 65535;
                break;
            case 2780:
                if (str.equals("WS")) {
                    c = 230;
                    break;
                }
                c = 65535;
                break;
            case 2803:
                if (str.equals("XK")) {
                    c = 231;
                    break;
                }
                c = 65535;
                break;
            case 2828:
                if (str.equals("YE")) {
                    c = 232;
                    break;
                }
                c = 65535;
                break;
            case 2843:
                if (str.equals("YT")) {
                    c = 233;
                    break;
                }
                c = 65535;
                break;
            case 2855:
                if (str.equals("ZA")) {
                    c = 234;
                    break;
                }
                c = 65535;
                break;
            case 2867:
                if (str.equals("ZM")) {
                    c = 235;
                    break;
                }
                c = 65535;
                break;
            case 2877:
                if (str.equals("ZW")) {
                    c = 236;
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
            case 26:
            case 29:
            case 'I':
            case 'O':
            case 'p':
            case 't':
            case 'x':
            case 223:
                return new int[]{1, 2, 0, 0, 2, 2};
            case 1:
                return new int[]{1, 4, 4, 4, 4, 0};
            case 2:
            case 'P':
                return new int[]{4, 3, 3, 4, 2, 2};
            case 3:
                return new int[]{2, 4, 1, 2, 2, 2};
            case 4:
                return new int[]{0, 2, 0, 3, 2, 2};
            case 5:
            case 231:
                return new int[]{1, 1, 1, 1, 2, 2};
            case 6:
                return new int[]{2, 3, 2, 3, 2, 2};
            case 7:
                return new int[]{4, 4, 3, 2, 2, 2};
            case '\b':
            case '>':
            case TsExtractor.TS_PACKET_SIZE /* 188 */:
                return new int[]{4, 2, 2, 2, 2, 2};
            case '\t':
            case 'l':
            case 210:
            case 220:
                return new int[]{2, 1, 1, 1, 2, 2};
            case '\n':
                return new int[]{2, 2, 3, 3, 2, 2};
            case 11:
                return new int[]{1, 0, 1, 1, 0, 0};
            case '\f':
                return new int[]{0, 1, 1, 1, 2, 0};
            case '\r':
                return new int[]{1, 3, 4, 4, 2, 2};
            case 14:
            case 'y':
            case 144:
            case 171:
            case PsExtractor.AUDIO_STREAM /* 192 */:
                return new int[]{0, 2, 2, 2, 2, 2};
            case 15:
            case 'K':
            case 128:
            case 169:
            case 194:
            case 211:
                return new int[]{3, 2, 3, 3, 2, 2};
            case 16:
                return new int[]{1, 2, 1, 1, 2, 2};
            case 17:
            case '8':
            case 'E':
            case 'N':
                return new int[]{0, 2, 0, 0, 2, 2};
            case 18:
                return new int[]{2, 1, 3, 3, 2, 2};
            case 19:
                return new int[]{0, 1, 4, 4, 3, 2};
            case 20:
                return new int[]{4, 3, 4, 3, 2, 2};
            case 21:
            case 145:
            case 190:
                return new int[]{0, 0, 0, 0, 1, 2};
            case 22:
                return new int[]{1, 2, 1, 3, 4, 2};
            case 23:
            case '[':
            case 'o':
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
            case 154:
            case 185:
            case HttpStatusCodesKt.HTTP_NOT_AUTHORITATIVE /* 203 */:
            case 224:
            case 232:
                return new int[]{4, 4, 4, 4, 2, 2};
            case 24:
                return new int[]{4, 4, 3, 3, 2, 2};
            case 25:
            case '2':
            case 222:
                return new int[]{1, 2, 2, 2, 2, 2};
            case 27:
            case '1':
                return new int[]{2, 2, 0, 0, 2, 2};
            case 28:
                return new int[]{1, 2, 3, 2, 2, 2};
            case 30:
                return new int[]{4, 4, 2, 2, 2, 2};
            case 31:
                return new int[]{3, 1, 3, 2, 2, 2};
            case ' ':
                return new int[]{3, 2, 1, 0, 2, 2};
            case '!':
                return new int[]{0, 1, 2, 3, 2, 2};
            case '\"':
                return new int[]{2, 4, 2, 1, 2, 2};
            case '#':
                return new int[]{0, 2, 2, 2, 3, 2};
            case '$':
                return new int[]{4, 2, 3, 2, 2, 2};
            case '%':
            case 'n':
                return new int[]{4, 2, 4, 2, 2, 2};
            case '&':
            case '=':
            case 'W':
                return new int[]{3, 4, 3, 3, 2, 2};
            case '\'':
                return new int[]{0, 0, 0, 1, 0, 2};
            case '(':
            case ':':
            case '{':
                return new int[]{3, 4, 4, 4, 2, 2};
            case ')':
            case 166:
                return new int[]{2, 2, 2, 1, 2, 2};
            case '*':
            case '_':
                return new int[]{1, 2, 2, 2, 3, 2};
            case '+':
                return new int[]{3, 3, 3, 3, 2, 2};
            case ',':
                return new int[]{2, 0, 1, 1, 3, 2};
            case '-':
                return new int[]{2, 3, 4, 3, 2, 2};
            case '.':
                return new int[]{2, 3, 4, 4, 2, 2};
            case '/':
            case '6':
            case 200:
            case HttpStatusCodesKt.HTTP_PARTIAL_CONTENT /* 206 */:
            case HttpStatusCodesKt.HTTP_ALREADY_REPORTED /* 208 */:
                return new int[]{4, 3, 4, 4, 2, 2};
            case '0':
                return new int[]{2, 1, 0, 0, 2, 2};
            case '3':
            case 's':
                return new int[]{1, 0, 0, 0, 0, 2};
            case '4':
            case 158:
                return new int[]{0, 0, 2, 0, 1, 2};
            case '5':
                return new int[]{0, 1, 2, 2, 2, 3};
            case '7':
                return new int[]{0, 0, 3, 2, 0, 2};
            case '9':
                return new int[]{3, 4, 4, 4, 4, 2};
            case ';':
                return new int[]{2, 3, 2, 1, 2, 2};
            case '<':
            case 'e':
            case 127:
            case 174:
            case 186:
            case 215:
                return new int[]{0, 0, 0, 0, 0, 2};
            case '?':
            case '^':
                return new int[]{0, 1, 1, 1, 2, 2};
            case '@':
                return new int[]{4, 3, 3, 1, 2, 2};
            case 'A':
                return new int[]{0, 0, 0, 3, 0, 2};
            case 'B':
                return new int[]{3, 1, 2, 2, 2, 2};
            case 'C':
            case 'k':
            case 'q':
                return new int[]{3, 2, 2, 2, 2, 2};
            case 'D':
                return new int[]{4, 2, 4, 1, 2, 2};
            case 'F':
                return new int[]{1, 2, 3, 1, 0, 2};
            case 'G':
            case HttpStatusCodesKt.HTTP_NO_CONTENT /* 204 */:
                return new int[]{3, 4, 1, 0, 2, 2};
            case 'H':
                return new int[]{0, 0, 1, 1, 1, 1};
            case 'J':
                return new int[]{1, 1, 1, 2, 2, 2};
            case 'L':
            case HttpStatusCodesKt.HTTP_IM_USED /* 226 */:
                return new int[]{0, 2, 0, 1, 2, 2};
            case 'M':
            case 152:
            case 228:
                return new int[]{3, 3, 3, 2, 2, 2};
            case 'Q':
                return new int[]{4, 3, 4, 2, 2, 2};
            case 'R':
            case 142:
                return new int[]{2, 1, 2, 3, 2, 2};
            case 'S':
                return new int[]{4, 2, 1, 4, 2, 2};
            case 'T':
            case 'Z':
            case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
                return new int[]{1, 0, 0, 0, 1, 2};
            case 'U':
                return new int[]{2, 3, 2, 2, 2, 2};
            case 'V':
            case 165:
                return new int[]{1, 2, 4, 4, 4, 2};
            case 'X':
                return new int[]{3, 2, 2, 1, 2, 2};
            case 'Y':
                return new int[]{0, 1, 2, 3, 2, 0};
            case '\\':
                return new int[]{0, 0, 0, 1, 3, 2};
            case ']':
                return new int[]{3, 1, 2, 2, 3, 2};
            case '`':
            case 217:
                return new int[]{0, 2, 1, 1, 2, 2};
            case 'a':
                return new int[]{1, 1, 3, 2, 3, 3};
            case 'b':
            case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
            case 214:
            case 229:
                return new int[]{4, 2, 2, 4, 2, 2};
            case 'c':
                return new int[]{3, 2, 2, 3, 2, 2};
            case 'd':
                return new int[]{3, 0, 1, 1, 4, 1};
            case 'f':
                return new int[]{0, 0, 0, 1, 1, 2};
            case 'g':
            case 233:
                return new int[]{4, 2, 2, 3, 2, 2};
            case 'h':
                return new int[]{2, 4, 3, 2, 2, 2};
            case 'i':
                return new int[]{2, 1, 1, 2, 2, 2};
            case 'j':
                return new int[]{0, 1, 1, 2, 2, 4};
            case 'm':
                return new int[]{2, 1, 4, 2, 2, 2};
            case 'r':
                return new int[]{0, 1, 1, 3, 4, 4};
            case 'u':
                return new int[]{2, 1, 2, 2, 2, 2};
            case 'v':
                return new int[]{1, 2, 1, 3, 2, 2};
            case 'w':
                return new int[]{3, 3, 2, 4, 2, 2};
            case 'z':
                return new int[]{3, 1, 3, 3, 4, 2};
            case '|':
                return new int[]{3, 3, 2, 2, 2, 2};
            case '}':
                return new int[]{0, 0, 0, 0, 2, 2};
            case '~':
                return new int[]{1, 0, 3, 2, 1, 4};
            case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                return new int[]{3, 3, 1, 1, 2, 2};
            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                return new int[]{0, 2, 2, 0, 2, 2};
            case 131:
            case 179:
                return new int[]{1, 0, 0, 0, 2, 2};
            case 132:
                return new int[]{2, 0, 0, 1, 2, 2};
            case 133:
            case 177:
                return new int[]{1, 2, 1, 2, 2, 2};
            case 136:
                return new int[]{1, 0, 0, 1, 3, 2};
            case 137:
            case 167:
                return new int[]{4, 3, 3, 2, 2, 2};
            case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                return new int[]{2, 4, 2, 3, 2, 2};
            case 139:
                return new int[]{2, 0, 1, 2, 2, 2};
            case 140:
            case ModuleDescriptor.MODULE_VERSION /* 141 */:
                return new int[]{0, 2, 4, 4, 2, 2};
            case 143:
            case 236:
                return new int[]{4, 2, 4, 4, 2, 2};
            case 146:
                return new int[]{3, 1, 1, 2, 2, 2};
            case 147:
                return new int[]{3, 4, 1, 4, 2, 2};
            case 148:
                return new int[]{4, 2, 3, 3, 2, 2};
            case 149:
                return new int[]{2, 4, 3, 4, 2, 2};
            case 150:
                return new int[]{1, 0, 3, 1, 3, 2};
            case 151:
                return new int[]{3, 1, 2, 1, 2, 2};
            case 153:
                return new int[]{3, 3, 4, 4, 2, 2};
            case 155:
                return new int[]{3, 4, 2, 1, 2, 2};
            case 156:
            case 164:
            case 198:
                return new int[]{2, 3, 3, 3, 2, 2};
            case 157:
                return new int[]{0, 2, 2, 3, 0, 3};
            case 159:
                return new int[]{2, 2, 4, 3, 2, 2};
            case 160:
            case 161:
                return new int[]{4, 2, 2, 1, 2, 2};
            case 162:
            case 170:
                return new int[]{1, 1, 2, 2, 4, 2};
            case 163:
                return new int[]{2, 3, 1, 3, 4, 2};
            case 168:
                return new int[]{2, 1, 3, 3, 3, 0};
            case TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
                return new int[]{2, 0, 2, 1, 2, 1};
            case 173:
                return new int[]{3, 4, 1, 2, 2, 2};
            case 175:
                return new int[]{2, 2, 4, 1, 2, 2};
            case CardPresenter.CARD_HEIGHT /* 176 */:
                return new int[]{2, 4, 4, 4, 4, 2};
            case 178:
                return new int[]{0, 0, 1, 2, 1, 2};
            case 180:
                return new int[]{1, 0, 0, 0, 4, 3};
            case 181:
                return new int[]{3, 4, 2, 0, 2, 2};
            case 182:
                return new int[]{3, 1, 1, 1, 2, 2};
            case 183:
                return new int[]{4, 2, 4, 3, 2, 2};
            case 184:
            case 209:
                return new int[]{4, 2, 1, 1, 2, 2};
            case 187:
                return new int[]{1, 1, 2, 2, 2, 1};
            case 191:
            case 218:
                return new int[]{3, 3, 4, 3, 2, 2};
            case 193:
                return new int[]{4, 4, 4, 3, 2, 2};
            case 195:
                return new int[]{2, 4, 3, 0, 2, 2};
            case 196:
                return new int[]{4, 3, 2, 3, 2, 2};
            case 197:
                return new int[]{2, 2, 1, 2, 2, 2};
            case 199:
            case HttpStatusCodesKt.HTTP_ACCEPTED /* 202 */:
                return new int[]{1, 2, 1, 0, 2, 2};
            case HttpStatusCodesKt.HTTP_CREATED /* 201 */:
                return new int[]{3, 3, 3, 4, 2, 2};
            case HttpStatusCodesKt.HTTP_RESET_CONTENT /* 205 */:
                return new int[]{0, 2, 2, 3, 3, 4};
            case HttpStatusCodesKt.HTTP_MULTI_STATUS /* 207 */:
                return new int[]{2, 2, 2, 4, 2, 2};
            case 212:
                return new int[]{1, 1, 0, 0, 2, 2};
            case 213:
                return new int[]{1, 4, 1, 3, 2, 2};
            case 216:
                return new int[]{3, 4, 3, 2, 2, 2};
            case 219:
                return new int[]{1, 0, 2, 2, 3, 1};
            case 221:
                return new int[]{2, 2, 3, 4, 2, 2};
            case 225:
                return new int[]{2, 2, 1, 1, 2, 2};
            case 227:
                return new int[]{0, 3, 3, 4, 2, 2};
            case 230:
                return new int[]{3, 1, 3, 1, 2, 2};
            case 234:
                return new int[]{3, 2, 2, 1, 1, 2};
            case 235:
                return new int[]{3, 3, 4, 2, 2, 2};
            default:
                return new int[]{2, 2, 2, 2, 2, 2};
        }
    }

    public static synchronized DefaultBandwidthMeter getSingletonInstance(Context context) {
        DefaultBandwidthMeter defaultBandwidthMeter;
        synchronized (DefaultBandwidthMeter.class) {
            try {
                if (f12439p == null) {
                    f12439p = new Builder(context).build();
                }
                defaultBandwidthMeter = f12439p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return defaultBandwidthMeter;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(eventListener);
        this.f12441b.addListener(handler, eventListener);
    }

    /* renamed from: b */
    public final long m2977b(int i) {
        Integer valueOf = Integer.valueOf(i);
        ImmutableMap immutableMap = this.f12440a;
        Long l = (Long) immutableMap.get(valueOf);
        if (l == null) {
            l = (Long) immutableMap.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    /* renamed from: c */
    public final synchronized void m2978c(int i) {
        int i2;
        int i3 = this.f12448i;
        if (i3 != 0 && !this.f12444e) {
            return;
        }
        if (this.f12453n) {
            i = this.f12454o;
        }
        if (i3 == i) {
            return;
        }
        this.f12448i = i;
        if (i != 1 && i != 0 && i != 8) {
            this.f12451l = m2977b(i);
            long elapsedRealtime = this.f12443d.elapsedRealtime();
            if (this.f12445f > 0) {
                i2 = (int) (elapsedRealtime - this.f12446g);
            } else {
                i2 = 0;
            }
            int i4 = i2;
            long j = this.f12447h;
            long j2 = this.f12451l;
            if (i4 != 0 || j != 0 || j2 != this.f12452m) {
                this.f12452m = j2;
                this.f12441b.bandwidthSample(i4, j, j2);
            }
            this.f12446g = elapsedRealtime;
            this.f12447h = 0L;
            this.f12450k = 0L;
            this.f12449j = 0L;
            this.f12442c.reset();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return this.f12451l;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public final /* synthetic */ long getTimeToFirstByteEstimateUs() {
        return AbstractC1721qe.m7032a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public TransferListener getTransferListener() {
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0012 A[Catch: all -> 0x001a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:12:0x0012), top: B:4:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010 A[DONT_GENERATE] */
    @Override // com.google.android.exoplayer2.upstream.TransferListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i) {
        boolean z2;
        if (z) {
            if (!dataSpec.isFlagSet(8)) {
                z2 = true;
                if (z2) {
                    return;
                }
                this.f12447h += i;
                return;
            }
        }
        z2 = false;
        if (z2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0012 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0014 A[Catch: all -> 0x0059, TRY_ENTER, TryCatch #0 {all -> 0x0059, blocks: (B:6:0x0007, B:13:0x0014, B:16:0x0019, B:18:0x0036, B:20:0x004f, B:23:0x0066, B:27:0x0072, B:30:0x0080, B:31:0x0079, B:32:0x005b, B:33:0x0084), top: B:5:0x0007 }] */
    @Override // com.google.android.exoplayer2.upstream.TransferListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z) {
        boolean z2;
        long j;
        long j2;
        boolean z3 = false;
        if (z) {
            try {
                if (!dataSpec.isFlagSet(8)) {
                    z2 = true;
                    if (z2) {
                        return;
                    }
                    if (this.f12445f > 0) {
                        z3 = true;
                    }
                    Assertions.checkState(z3);
                    long elapsedRealtime = this.f12443d.elapsedRealtime();
                    int i = (int) (elapsedRealtime - this.f12446g);
                    this.f12449j += i;
                    long j3 = this.f12450k;
                    long j4 = this.f12447h;
                    this.f12450k = j3 + j4;
                    if (i > 0) {
                        this.f12442c.addSample((int) Math.sqrt(j4), (((float) j4) * 8000.0f) / i);
                        if (this.f12449j < ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                            if (this.f12450k >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                            }
                            j = this.f12447h;
                            j2 = this.f12451l;
                            if (i == 0 || j != 0 || j2 != this.f12452m) {
                                this.f12452m = j2;
                                this.f12441b.bandwidthSample(i, j, j2);
                            }
                            this.f12446g = elapsedRealtime;
                            this.f12447h = 0L;
                        }
                        this.f12451l = this.f12442c.getPercentile(0.5f);
                        j = this.f12447h;
                        j2 = this.f12451l;
                        if (i == 0) {
                        }
                        this.f12452m = j2;
                        this.f12441b.bandwidthSample(i, j, j2);
                        this.f12446g = elapsedRealtime;
                        this.f12447h = 0L;
                    }
                    this.f12445f--;
                    return;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z2 = false;
        if (z2) {
        }
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0013 A[Catch: all -> 0x0020, TRY_ENTER, TryCatch #0 {all -> 0x0020, blocks: (B:6:0x0006, B:13:0x0013, B:15:0x0017, B:16:0x0022), top: B:5:0x0006 }] */
    @Override // com.google.android.exoplayer2.upstream.TransferListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z) {
        boolean z2;
        if (z) {
            try {
                if (!dataSpec.isFlagSet(8)) {
                    z2 = true;
                    if (z2) {
                        return;
                    }
                    if (this.f12445f == 0) {
                        this.f12446g = this.f12443d.elapsedRealtime();
                    }
                    this.f12445f++;
                    return;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z2 = false;
        if (z2) {
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void removeEventListener(BandwidthMeter.EventListener eventListener) {
        this.f12441b.removeListener(eventListener);
    }

    public synchronized void setNetworkTypeOverride(int i) {
        this.f12454o = i;
        this.f12453n = true;
        m2978c(i);
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        public final Context f12455a;

        /* renamed from: b */
        public HashMap f12456b;

        /* renamed from: c */
        public int f12457c;

        /* renamed from: d */
        public Clock f12458d;

        /* renamed from: e */
        public boolean f12459e;

        public Builder(Context context) {
            Context applicationContext;
            if (context == null) {
                applicationContext = null;
            } else {
                applicationContext = context.getApplicationContext();
            }
            this.f12455a = applicationContext;
            this.f12456b = m2979a(Util.getCountryCode(context));
            this.f12457c = 2000;
            this.f12458d = Clock.DEFAULT;
            this.f12459e = true;
        }

        /* renamed from: a */
        public static HashMap m2979a(String str) {
            int[] m2976a = DefaultBandwidthMeter.m2976a(str);
            HashMap hashMap = new HashMap(8);
            hashMap.put(0, 1000000L);
            ImmutableList<Long> immutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
            hashMap.put(2, immutableList.get(m2976a[0]));
            hashMap.put(3, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G.get(m2976a[1]));
            hashMap.put(4, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G.get(m2976a[2]));
            hashMap.put(5, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G.get(m2976a[3]));
            hashMap.put(10, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA.get(m2976a[4]));
            hashMap.put(9, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA.get(m2976a[5]));
            hashMap.put(7, immutableList.get(m2976a[0]));
            return hashMap;
        }

        public DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.f12455a, this.f12456b, this.f12457c, this.f12458d, this.f12459e);
        }

        public Builder setClock(Clock clock) {
            this.f12458d = clock;
            return this;
        }

        public Builder setInitialBitrateEstimate(long j) {
            Iterator it = this.f12456b.keySet().iterator();
            while (it.hasNext()) {
                setInitialBitrateEstimate(((Integer) it.next()).intValue(), j);
            }
            return this;
        }

        public Builder setResetOnNetworkTypeChange(boolean z) {
            this.f12459e = z;
            return this;
        }

        public Builder setSlidingWindowMaxWeight(int i) {
            this.f12457c = i;
            return this;
        }

        public Builder setInitialBitrateEstimate(int i, long j) {
            this.f12456b.put(Integer.valueOf(i), Long.valueOf(j));
            return this;
        }

        public Builder setInitialBitrateEstimate(String str) {
            this.f12456b = m2979a(Ascii.toUpperCase(str));
            return this;
        }
    }

    public DefaultBandwidthMeter(Context context, Map map, int i, Clock clock, boolean z) {
        this.f12440a = ImmutableMap.copyOf(map);
        this.f12441b = new BandwidthMeter.EventListener.EventDispatcher();
        this.f12442c = new SlidingPercentile(i);
        this.f12443d = clock;
        this.f12444e = z;
        if (context != null) {
            NetworkTypeObserver networkTypeObserver = NetworkTypeObserver.getInstance(context);
            int networkType = networkTypeObserver.getNetworkType();
            this.f12448i = networkType;
            this.f12451l = m2977b(networkType);
            networkTypeObserver.register(new NetworkTypeObserver.Listener() { // from class: j00
                @Override // com.google.android.exoplayer2.util.NetworkTypeObserver.Listener
                public final void onNetworkTypeChanged(int i2) {
                    ImmutableList<Long> immutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
                    DefaultBandwidthMeter.this.m2978c(i2);
                }
            });
            return;
        }
        this.f12448i = 0;
        this.f12451l = m2977b(0);
    }
}
