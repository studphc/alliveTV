package okio;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0080\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\u0080\bø\u0001\u0000\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, m5569d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
@JvmName(name = "Utf8")
/* loaded from: classes2.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        return (i >= 0 && i < 32) || (127 <= i && i < 160);
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] bArr, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i3 = i + 1;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            yield.invoke(valueOf);
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i3];
        if ((b2 & 192) == 128) {
            int i4 = (b2 ^ 3968) ^ (b << 6);
            if (i4 < 128) {
                yield.invoke(valueOf);
                return 2;
            }
            yield.invoke(Integer.valueOf(i4));
            return 2;
        }
        yield.invoke(valueOf);
        return 1;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] bArr, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i3 = i + 2;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            yield.invoke(valueOf);
            int i4 = i + 1;
            if (i2 <= i4 || (bArr[i4] & 192) != 128) {
                return 1;
            }
            return 2;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if ((b2 & 192) == 128) {
            byte b3 = bArr[i3];
            if ((b3 & 192) == 128) {
                int i5 = ((b3 ^ (-123008)) ^ (b2 << 6)) ^ (b << Ascii.f14457FF);
                if (i5 < 2048) {
                    yield.invoke(valueOf);
                    return 3;
                }
                if (55296 <= i5 && i5 < 57344) {
                    yield.invoke(valueOf);
                    return 3;
                }
                yield.invoke(Integer.valueOf(i5));
                return 3;
            }
            yield.invoke(valueOf);
            return 2;
        }
        yield.invoke(valueOf);
        return 1;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] bArr, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        int i3 = i + 3;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            yield.invoke(valueOf);
            int i4 = i + 1;
            if (i2 <= i4 || (bArr[i4] & 192) != 128) {
                return 1;
            }
            int i5 = i + 2;
            if (i2 <= i5 || (bArr[i5] & 192) != 128) {
                return 2;
            }
            return 3;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if ((b2 & 192) == 128) {
            byte b3 = bArr[i + 2];
            if ((b3 & 192) == 128) {
                byte b4 = bArr[i3];
                if ((b4 & 192) == 128) {
                    int i6 = (((b4 ^ 3678080) ^ (b3 << 6)) ^ (b2 << Ascii.f14457FF)) ^ (b << Ascii.DC2);
                    if (i6 > 1114111) {
                        yield.invoke(valueOf);
                        return 4;
                    }
                    if (55296 <= i6 && i6 < 57344) {
                        yield.invoke(valueOf);
                        return 4;
                    }
                    if (i6 < 65536) {
                        yield.invoke(valueOf);
                        return 4;
                    }
                    yield.invoke(Integer.valueOf(i6));
                    return 4;
                }
                yield.invoke(valueOf);
                return 3;
            }
            yield.invoke(valueOf);
            return 2;
        }
        yield.invoke(valueOf);
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e2, code lost:
    
        if ((r11[r0] & 192) == 128) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007e, code lost:
    
        if ((r11[r0] & 192) == 128) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void processUtf16Chars(@NotNull byte[] bArr, int i, int i2, @NotNull Function1<? super Character, Unit> yield) {
        char c;
        char c2;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        while (i < i2) {
            byte b = bArr[i];
            if (b >= 0) {
                yield.invoke(Character.valueOf((char) b));
                i++;
                while (i < i2) {
                    byte b2 = bArr[i];
                    if (b2 >= 0) {
                        i++;
                        yield.invoke(Character.valueOf((char) b2));
                    }
                }
            } else {
                int i3 = 2;
                if ((b >> 5) == -2) {
                    int i4 = i + 1;
                    if (i2 > i4) {
                        byte b3 = bArr[i4];
                        if ((b3 & 192) == 128) {
                            int i5 = (b << 6) ^ (b3 ^ 3968);
                            if (i5 < 128) {
                                c = (char) REPLACEMENT_CODE_POINT;
                            } else {
                                c = (char) i5;
                            }
                            yield.invoke(Character.valueOf(c));
                            i += i3;
                        }
                    }
                    yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                    i3 = 1;
                    i += i3;
                } else if ((b >> 4) == -2) {
                    int i6 = i + 2;
                    if (i2 <= i6) {
                        yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                        int i7 = i + 1;
                        if (i2 > i7) {
                        }
                        i3 = 1;
                        i += i3;
                    } else {
                        byte b4 = bArr[i + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = bArr[i6];
                            if ((b5 & 192) == 128) {
                                int i8 = (b << Ascii.f14457FF) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                                if (i8 < 2048 || (55296 <= i8 && i8 < 57344)) {
                                    c2 = (char) REPLACEMENT_CODE_POINT;
                                } else {
                                    c2 = (char) i8;
                                }
                                yield.invoke(Character.valueOf(c2));
                                i3 = 3;
                                i += i3;
                            } else {
                                yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                i += i3;
                            }
                        } else {
                            yield.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            i3 = 1;
                            i += i3;
                        }
                    }
                } else if ((b >> 3) == -2) {
                    int i9 = i + 3;
                    if (i2 <= i9) {
                        yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                        int i10 = i + 1;
                        if (i2 > i10 && (bArr[i10] & 192) == 128) {
                            int i11 = i + 2;
                            if (i2 > i11) {
                            }
                            i += i3;
                        }
                        i3 = 1;
                        i += i3;
                    } else {
                        byte b6 = bArr[i + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = bArr[i9];
                                if ((b8 & 192) == 128) {
                                    int i12 = (b << Ascii.DC2) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << Ascii.f14457FF));
                                    if (i12 > 1114111 || ((55296 <= i12 && i12 < 57344) || i12 < 65536 || i12 == 65533)) {
                                        yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    } else {
                                        yield.invoke(Character.valueOf((char) ((i12 >>> 10) + HIGH_SURROGATE_HEADER)));
                                        yield.invoke(Character.valueOf((char) ((i12 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + LOG_SURROGATE_HEADER)));
                                    }
                                    i3 = 4;
                                } else {
                                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    i3 = 3;
                                }
                            } else {
                                yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            }
                            i += i3;
                        } else {
                            yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            i3 = 1;
                            i += i3;
                        }
                    }
                } else {
                    yield.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                    i++;
                }
            }
        }
    }

    public static final void processUtf8Bytes(@NotNull String str, int i, int i2, @NotNull Function1<? super Byte, Unit> yield) {
        int i3;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        while (i < i2) {
            char charAt2 = str.charAt(i);
            if (Intrinsics.compare((int) charAt2, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) charAt2));
                i++;
                while (i < i2 && Intrinsics.compare((int) str.charAt(i), 128) < 0) {
                    yield.invoke(Byte.valueOf((byte) str.charAt(i)));
                    i++;
                }
            } else {
                if (Intrinsics.compare((int) charAt2, 2048) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> 6) | PsExtractor.AUDIO_STREAM)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (55296 <= charAt2 && charAt2 < 57344) {
                    if (Intrinsics.compare((int) charAt2, 56319) <= 0 && i2 > (i3 = i + 1) && 56320 <= (charAt = str.charAt(i3)) && charAt < 57344) {
                        int charAt3 = (str.charAt(i3) + (charAt2 << '\n')) - 56613888;
                        yield.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | PsExtractor.VIDEO_STREAM_MASK)));
                        yield.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                        i += 2;
                    } else {
                        yield.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                    }
                } else {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> '\f') | 224)));
                    yield.invoke(Byte.valueOf((byte) (((charAt2 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                }
                i++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e0, code lost:
    
        if ((r11[r0] & 192) == 128) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007c, code lost:
    
        if ((r11[r0] & 192) == 128) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void processUtf8CodePoints(@NotNull byte[] bArr, int i, int i2, @NotNull Function1<? super Integer, Unit> yield) {
        Integer valueOf;
        Integer valueOf2;
        Integer valueOf3;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(yield, "yield");
        while (i < i2) {
            byte b = bArr[i];
            if (b >= 0) {
                yield.invoke(Integer.valueOf(b));
                i++;
                while (i < i2) {
                    byte b2 = bArr[i];
                    if (b2 >= 0) {
                        i++;
                        yield.invoke(Integer.valueOf(b2));
                    }
                }
            } else {
                int i3 = 2;
                if ((b >> 5) == -2) {
                    int i4 = i + 1;
                    if (i2 > i4) {
                        byte b3 = bArr[i4];
                        if ((b3 & 192) == 128) {
                            int i5 = (b << 6) ^ (b3 ^ 3968);
                            if (i5 < 128) {
                                valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
                            } else {
                                valueOf = Integer.valueOf(i5);
                            }
                            yield.invoke(valueOf);
                            i += i3;
                        }
                    }
                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    i3 = 1;
                    i += i3;
                } else if ((b >> 4) == -2) {
                    int i6 = i + 2;
                    if (i2 <= i6) {
                        yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        int i7 = i + 1;
                        if (i2 > i7) {
                        }
                        i3 = 1;
                        i += i3;
                    } else {
                        byte b4 = bArr[i + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = bArr[i6];
                            if ((b5 & 192) == 128) {
                                int i8 = (b << Ascii.f14457FF) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                                if (i8 < 2048 || (55296 <= i8 && i8 < 57344)) {
                                    valueOf2 = Integer.valueOf(REPLACEMENT_CODE_POINT);
                                } else {
                                    valueOf2 = Integer.valueOf(i8);
                                }
                                yield.invoke(valueOf2);
                                i3 = 3;
                                i += i3;
                            } else {
                                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                i += i3;
                            }
                        } else {
                            yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            i3 = 1;
                            i += i3;
                        }
                    }
                } else if ((b >> 3) == -2) {
                    int i9 = i + 3;
                    if (i2 <= i9) {
                        yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        int i10 = i + 1;
                        if (i2 > i10 && (bArr[i10] & 192) == 128) {
                            int i11 = i + 2;
                            if (i2 > i11) {
                            }
                            i += i3;
                        }
                        i3 = 1;
                        i += i3;
                    } else {
                        byte b6 = bArr[i + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = bArr[i9];
                                if ((b8 & 192) == 128) {
                                    int i12 = (b << Ascii.DC2) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << Ascii.f14457FF));
                                    if (i12 > 1114111 || ((55296 <= i12 && i12 < 57344) || i12 < 65536)) {
                                        valueOf3 = Integer.valueOf(REPLACEMENT_CODE_POINT);
                                    } else {
                                        valueOf3 = Integer.valueOf(i12);
                                    }
                                    yield.invoke(valueOf3);
                                    i3 = 4;
                                } else {
                                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    i3 = 3;
                                }
                            } else {
                                yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            }
                            i += i3;
                        } else {
                            yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            i3 = 1;
                            i += i3;
                        }
                    }
                } else {
                    yield.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    i++;
                }
            }
        }
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, 0, 0, 3, null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, i, 0, 2, null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ye0.m8291k(i, "beginIndex < 0: ").toString());
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                StringBuilder m8299s = ye0.m8299s(i2, "endIndex > string.length: ", " > ");
                m8299s.append(str.length());
                throw new IllegalArgumentException(m8299s.toString().toString());
            }
            long j = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    j++;
                } else {
                    if (charAt < 2048) {
                        i3 = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i3 = 3;
                    } else {
                        int i4 = i + 1;
                        char charAt2 = i4 < i2 ? str.charAt(i4) : (char) 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j++;
                            i = i4;
                        } else {
                            j += 4;
                            i += 2;
                        }
                    }
                    j += i3;
                }
                i++;
            }
            return j;
        }
        throw new IllegalArgumentException(ye0.m8293m(i2, "endIndex < beginIndex: ", " < ", i).toString());
    }
}
