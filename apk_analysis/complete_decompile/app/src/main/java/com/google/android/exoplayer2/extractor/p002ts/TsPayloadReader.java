package com.google.android.exoplayer2.extractor.p002ts;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public interface TsPayloadReader {
    public static final int FLAG_DATA_ALIGNMENT_INDICATOR = 4;
    public static final int FLAG_PAYLOAD_UNIT_START_INDICATOR = 1;
    public static final int FLAG_RANDOM_ACCESS_INDICATOR = 2;

    /* loaded from: classes.dex */
    public static final class DvbSubtitleInfo {
        public final byte[] initializationData;
        public final String language;
        public final int type;

        public DvbSubtitleInfo(String str, int i, byte[] bArr) {
            this.language = str;
            this.type = i;
            this.initializationData = bArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class EsInfo {
        public final byte[] descriptorBytes;
        public final List<DvbSubtitleInfo> dvbSubtitleInfos;

        @Nullable
        public final String language;
        public final int streamType;

        public EsInfo(int i, @Nullable String str, @Nullable List<DvbSubtitleInfo> list, byte[] bArr) {
            List<DvbSubtitleInfo> unmodifiableList;
            this.streamType = i;
            this.language = str;
            if (list == null) {
                unmodifiableList = Collections.emptyList();
            } else {
                unmodifiableList = Collections.unmodifiableList(list);
            }
            this.dvbSubtitleInfos = unmodifiableList;
            this.descriptorBytes = bArr;
        }
    }

    /* loaded from: classes.dex */
    public interface Factory {
        SparseArray<TsPayloadReader> createInitialPayloadReaders();

        @Nullable
        TsPayloadReader createPayloadReader(int i, EsInfo esInfo);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    /* loaded from: classes.dex */
    public static final class TrackIdGenerator {

        /* renamed from: a */
        public final String f10568a;

        /* renamed from: b */
        public final int f10569b;

        /* renamed from: c */
        public final int f10570c;

        /* renamed from: d */
        public int f10571d;

        /* renamed from: e */
        public String f10572e;

        public TrackIdGenerator(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public void generateNewId() {
            int i;
            int i2 = this.f10571d;
            if (i2 == Integer.MIN_VALUE) {
                i = this.f10569b;
            } else {
                i = i2 + this.f10570c;
            }
            this.f10571d = i;
            this.f10572e = this.f10568a + this.f10571d;
        }

        public String getFormatId() {
            if (this.f10571d != Integer.MIN_VALUE) {
                return this.f10572e;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public int getTrackId() {
            int i = this.f10571d;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public TrackIdGenerator(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                str = i + "/";
            } else {
                str = "";
            }
            this.f10568a = str;
            this.f10569b = i2;
            this.f10570c = i3;
            this.f10571d = Integer.MIN_VALUE;
            this.f10572e = "";
        }
    }

    void consume(ParsableByteArray parsableByteArray, int i);

    void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void seek();
}
