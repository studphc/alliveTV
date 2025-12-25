package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.avi.AviExtractor;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

/* loaded from: classes.dex */
public final class i91 implements InterfaceC1979xd {

    /* renamed from: a */
    public final ImmutableList f18342a;

    /* renamed from: b */
    public final int f18343b;

    public i91(int i, ImmutableList immutableList) {
        this.f18343b = i;
        this.f18342a = immutableList;
    }

    /* renamed from: b */
    public static i91 m5201b(int i, ParsableByteArray parsableByteArray) {
        String str;
        String str2;
        InterfaceC1979xd c0015ae;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int limit = parsableByteArray.limit();
        int i2 = -2;
        while (parsableByteArray.bytesLeft() > 8) {
            int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
            int position = parsableByteArray.getPosition() + parsableByteArray.readLittleEndianInt();
            parsableByteArray.setLimit(position);
            if (readLittleEndianInt == 1414744396) {
                c0015ae = m5201b(parsableByteArray.readLittleEndianInt(), parsableByteArray);
            } else {
                zn2 zn2Var = null;
                switch (readLittleEndianInt) {
                    case AviExtractor.FOURCC_strf /* 1718776947 */:
                        if (i2 == 2) {
                            parsableByteArray.skipBytes(4);
                            int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
                            int readLittleEndianInt3 = parsableByteArray.readLittleEndianInt();
                            parsableByteArray.skipBytes(4);
                            int readLittleEndianInt4 = parsableByteArray.readLittleEndianInt();
                            switch (readLittleEndianInt4) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str2 = MimeTypes.VIDEO_MP4V;
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str2 = MimeTypes.VIDEO_H264;
                                    break;
                                case 842289229:
                                    str2 = MimeTypes.VIDEO_MP42;
                                    break;
                                case 859066445:
                                    str2 = MimeTypes.VIDEO_MP43;
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str2 = MimeTypes.VIDEO_MJPEG;
                                    break;
                                default:
                                    str2 = null;
                                    break;
                            }
                            if (str2 == null) {
                                AbstractC1726qj.m7036A(readLittleEndianInt4, "Ignoring track with unsupported compression ", "StreamFormatChunk");
                                break;
                            } else {
                                Format.Builder builder2 = new Format.Builder();
                                builder2.setWidth(readLittleEndianInt2).setHeight(readLittleEndianInt3).setSampleMimeType(str2);
                                zn2Var = new zn2(builder2.build());
                                break;
                            }
                        } else if (i2 == 1) {
                            int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                            if (readLittleEndianUnsignedShort != 1) {
                                if (readLittleEndianUnsignedShort != 85) {
                                    if (readLittleEndianUnsignedShort != 255) {
                                        if (readLittleEndianUnsignedShort != 8192) {
                                            if (readLittleEndianUnsignedShort != 8193) {
                                                str = null;
                                            } else {
                                                str = MimeTypes.AUDIO_DTS;
                                            }
                                        } else {
                                            str = MimeTypes.AUDIO_AC3;
                                        }
                                    } else {
                                        str = MimeTypes.AUDIO_AAC;
                                    }
                                } else {
                                    str = MimeTypes.AUDIO_MPEG;
                                }
                            } else {
                                str = MimeTypes.AUDIO_RAW;
                            }
                            if (str == null) {
                                AbstractC1726qj.m7036A(readLittleEndianUnsignedShort, "Ignoring track with unsupported format tag ", "StreamFormatChunk");
                                break;
                            } else {
                                int readLittleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
                                int readLittleEndianInt5 = parsableByteArray.readLittleEndianInt();
                                parsableByteArray.skipBytes(6);
                                int pcmEncoding = Util.getPcmEncoding(parsableByteArray.readUnsignedShort());
                                int readLittleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
                                byte[] bArr = new byte[readLittleEndianUnsignedShort3];
                                parsableByteArray.readBytes(bArr, 0, readLittleEndianUnsignedShort3);
                                Format.Builder builder3 = new Format.Builder();
                                builder3.setSampleMimeType(str).setChannelCount(readLittleEndianUnsignedShort2).setSampleRate(readLittleEndianInt5);
                                if (MimeTypes.AUDIO_RAW.equals(str) && pcmEncoding != 0) {
                                    builder3.setPcmEncoding(pcmEncoding);
                                }
                                if (MimeTypes.AUDIO_AAC.equals(str) && readLittleEndianUnsignedShort3 > 0) {
                                    builder3.setInitializationData(ImmutableList.m3903of(bArr));
                                }
                                zn2Var = new zn2(builder3.build());
                                break;
                            }
                        } else {
                            Log.m3027w("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + Util.getTrackTypeString(i2));
                            break;
                        }
                    case AviExtractor.FOURCC_avih /* 1751742049 */:
                        int readLittleEndianInt6 = parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(8);
                        int readLittleEndianInt7 = parsableByteArray.readLittleEndianInt();
                        int readLittleEndianInt8 = parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(4);
                        parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(12);
                        c0015ae = new C0015ae(readLittleEndianInt6, readLittleEndianInt7, readLittleEndianInt8);
                        break;
                    case AviExtractor.FOURCC_strh /* 1752331379 */:
                        int readLittleEndianInt9 = parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(12);
                        parsableByteArray.readLittleEndianInt();
                        int readLittleEndianInt10 = parsableByteArray.readLittleEndianInt();
                        int readLittleEndianInt11 = parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(4);
                        int readLittleEndianInt12 = parsableByteArray.readLittleEndianInt();
                        int readLittleEndianInt13 = parsableByteArray.readLittleEndianInt();
                        parsableByteArray.skipBytes(8);
                        c0015ae = new C0554be(readLittleEndianInt9, readLittleEndianInt10, readLittleEndianInt11, readLittleEndianInt12, readLittleEndianInt13);
                        break;
                    case AviExtractor.FOURCC_strn /* 1852994675 */:
                        c0015ae = new ao2(parsableByteArray.readString(parsableByteArray.bytesLeft()));
                        break;
                }
                c0015ae = zn2Var;
            }
            if (c0015ae != null) {
                if (c0015ae.getType() == 1752331379) {
                    int i3 = ((C0554be) c0015ae).f7973a;
                    if (i3 != 1935960438) {
                        if (i3 != 1935963489) {
                            if (i3 != 1937012852) {
                                Log.m3027w("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(i3));
                                i2 = -1;
                            } else {
                                i2 = 3;
                            }
                        } else {
                            i2 = 1;
                        }
                    } else {
                        i2 = 2;
                    }
                }
                builder.add((ImmutableList.Builder) c0015ae);
            }
            parsableByteArray.setPosition(position);
            parsableByteArray.setLimit(limit);
        }
        return new i91(i, builder.build());
    }

    /* renamed from: a */
    public final InterfaceC1979xd m5202a(Class cls) {
        UnmodifiableIterator it = this.f18342a.iterator();
        while (it.hasNext()) {
            InterfaceC1979xd interfaceC1979xd = (InterfaceC1979xd) it.next();
            if (interfaceC1979xd.getClass() == cls) {
                return interfaceC1979xd;
            }
        }
        return null;
    }

    @Override // p000.InterfaceC1979xd
    public final int getType() {
        return this.f18343b;
    }
}
