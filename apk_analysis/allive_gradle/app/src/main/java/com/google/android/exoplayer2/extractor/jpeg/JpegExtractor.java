package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import org.xmlpull.v1.XmlPullParserException;
import p000.C1972x6;
import p000.gn2;
import p000.l63;

/* loaded from: classes.dex */
public final class JpegExtractor implements Extractor {

    /* renamed from: b */
    public ExtractorOutput f10175b;

    /* renamed from: c */
    public int f10176c;

    /* renamed from: d */
    public int f10177d;

    /* renamed from: e */
    public int f10178e;

    /* renamed from: g */
    public MotionPhotoMetadata f10180g;

    /* renamed from: h */
    public ExtractorInput f10181h;

    /* renamed from: i */
    public gn2 f10182i;

    /* renamed from: j */
    public Mp4Extractor f10183j;

    /* renamed from: a */
    public final ParsableByteArray f10174a = new ParsableByteArray(6);

    /* renamed from: f */
    public long f10179f = -1;

    /* renamed from: a */
    public final void m2539a() {
        m2540b(new Metadata.Entry[0]);
        ((ExtractorOutput) Assertions.checkNotNull(this.f10175b)).endTracks();
        this.f10175b.seekMap(new SeekMap.Unseekable(C0643C.TIME_UNSET));
        this.f10176c = 6;
    }

    /* renamed from: b */
    public final void m2540b(Metadata.Entry... entryArr) {
        ((ExtractorOutput) Assertions.checkNotNull(this.f10175b)).track(1024, 4).format(new Format.Builder().setContainerMimeType(MimeTypes.IMAGE_JPEG).setMetadata(new Metadata(entryArr)).build());
    }

    /* renamed from: c */
    public final int m2541c(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = this.f10174a;
        parsableByteArray.reset(2);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 2);
        return parsableByteArray.readUnsignedShort();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10175b = extractorOutput;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0169  */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        String readNullTerminatedString;
        C1972x6 c1972x6;
        MotionPhotoMetadata motionPhotoMetadata;
        long j;
        int i = this.f10176c;
        ParsableByteArray parsableByteArray = this.f10174a;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i == 6) {
                                return -1;
                            }
                            throw new IllegalStateException();
                        }
                        if (this.f10182i == null || extractorInput != this.f10181h) {
                            this.f10181h = extractorInput;
                            this.f10182i = new gn2(extractorInput, this.f10179f);
                        }
                        int read = ((Mp4Extractor) Assertions.checkNotNull(this.f10183j)).read(this.f10182i, positionHolder);
                        if (read == 1) {
                            positionHolder.position += this.f10179f;
                        }
                        return read;
                    }
                    long position = extractorInput.getPosition();
                    long j2 = this.f10179f;
                    if (position != j2) {
                        positionHolder.position = j2;
                        return 1;
                    }
                    if (!extractorInput.peekFully(parsableByteArray.getData(), 0, 1, true)) {
                        m2539a();
                    } else {
                        extractorInput.resetPeekPosition();
                        if (this.f10183j == null) {
                            this.f10183j = new Mp4Extractor();
                        }
                        gn2 gn2Var = new gn2(extractorInput, this.f10179f);
                        this.f10182i = gn2Var;
                        if (this.f10183j.sniff(gn2Var)) {
                            this.f10183j.init(new StartOffsetExtractorOutput(this.f10179f, (ExtractorOutput) Assertions.checkNotNull(this.f10175b)));
                            m2540b((Metadata.Entry) Assertions.checkNotNull(this.f10180g));
                            this.f10176c = 5;
                        } else {
                            m2539a();
                        }
                    }
                    return 0;
                }
                if (this.f10177d == 65505) {
                    ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.f10178e);
                    extractorInput.readFully(parsableByteArray2.getData(), 0, this.f10178e);
                    if (this.f10180g == null && "http://ns.adobe.com/xap/1.0/".equals(parsableByteArray2.readNullTerminatedString()) && (readNullTerminatedString = parsableByteArray2.readNullTerminatedString()) != null) {
                        long length = extractorInput.getLength();
                        if (length != -1) {
                            try {
                                c1972x6 = l63.m5863a(readNullTerminatedString);
                            } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
                                Log.m3027w("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
                                c1972x6 = null;
                            }
                            if (c1972x6 != null) {
                                ImmutableList immutableList = (ImmutableList) c1972x6.f28447c;
                                if (immutableList.size() >= 2) {
                                    int size = immutableList.size() - 1;
                                    boolean z = false;
                                    long j3 = -1;
                                    long j4 = -1;
                                    long j5 = -1;
                                    long j6 = -1;
                                    while (size >= 0) {
                                        MotionPhotoDescription$ContainerItem motionPhotoDescription$ContainerItem = (MotionPhotoDescription$ContainerItem) immutableList.get(size);
                                        boolean equals = MimeTypes.VIDEO_MP4.equals(motionPhotoDescription$ContainerItem.mime) | z;
                                        if (size == 0) {
                                            length -= motionPhotoDescription$ContainerItem.padding;
                                            j = 0;
                                        } else {
                                            j = length - motionPhotoDescription$ContainerItem.length;
                                        }
                                        long j7 = j;
                                        long j8 = length;
                                        length = j7;
                                        if (equals && length != j8) {
                                            j6 = j8 - length;
                                            j5 = length;
                                            equals = false;
                                        }
                                        if (size == 0) {
                                            j4 = j8;
                                            j3 = length;
                                        }
                                        size--;
                                        z = equals;
                                    }
                                    if (j5 != -1 && j6 != -1 && j3 != -1 && j4 != -1) {
                                        motionPhotoMetadata = new MotionPhotoMetadata(j3, j4, c1972x6.f28446b, j5, j6);
                                        this.f10180g = motionPhotoMetadata;
                                        if (motionPhotoMetadata != null) {
                                            this.f10179f = motionPhotoMetadata.videoStartPosition;
                                        }
                                    }
                                }
                            }
                        }
                        motionPhotoMetadata = null;
                        this.f10180g = motionPhotoMetadata;
                        if (motionPhotoMetadata != null) {
                        }
                    }
                } else {
                    extractorInput.skipFully(this.f10178e);
                }
                this.f10176c = 0;
                return 0;
            }
            parsableByteArray.reset(2);
            extractorInput.readFully(parsableByteArray.getData(), 0, 2);
            this.f10178e = parsableByteArray.readUnsignedShort() - 2;
            this.f10176c = 2;
            return 0;
        }
        parsableByteArray.reset(2);
        extractorInput.readFully(parsableByteArray.getData(), 0, 2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        this.f10177d = readUnsignedShort;
        if (readUnsignedShort == 65498) {
            if (this.f10179f != -1) {
                this.f10176c = 4;
                return 0;
            }
            m2539a();
            return 0;
        }
        if ((readUnsignedShort >= 65488 && readUnsignedShort <= 65497) || readUnsignedShort == 65281) {
            return 0;
        }
        this.f10176c = 1;
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        Mp4Extractor mp4Extractor = this.f10183j;
        if (mp4Extractor != null) {
            mp4Extractor.release();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        if (j == 0) {
            this.f10176c = 0;
            this.f10183j = null;
        } else if (this.f10176c == 5) {
            ((Mp4Extractor) Assertions.checkNotNull(this.f10183j)).seek(j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        if (m2541c(extractorInput) != 65496) {
            return false;
        }
        int m2541c = m2541c(extractorInput);
        this.f10177d = m2541c;
        ParsableByteArray parsableByteArray = this.f10174a;
        if (m2541c == 65504) {
            parsableByteArray.reset(2);
            extractorInput.peekFully(parsableByteArray.getData(), 0, 2);
            extractorInput.advancePeekPosition(parsableByteArray.readUnsignedShort() - 2);
            this.f10177d = m2541c(extractorInput);
        }
        if (this.f10177d != 65505) {
            return false;
        }
        extractorInput.advancePeekPosition(2);
        parsableByteArray.reset(6);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 6);
        if (parsableByteArray.readUnsignedInt() != 1165519206 || parsableByteArray.readUnsignedShort() != 0) {
            return false;
        }
        return true;
    }
}
