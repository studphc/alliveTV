package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.data.DataRewinder;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ParcelFileDescriptorRewinder implements DataRewinder<ParcelFileDescriptor> {

    /* renamed from: a */
    public final InternalRewinder f8657a;

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class Factory implements DataRewinder.Factory<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public Class<ParcelFileDescriptor> getDataClass() {
            return ParcelFileDescriptor.class;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public DataRewinder<ParcelFileDescriptor> build(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class InternalRewinder {

        /* renamed from: a */
        public final ParcelFileDescriptor f8658a;

        public InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.f8658a = parcelFileDescriptor;
        }

        public ParcelFileDescriptor rewind() {
            ParcelFileDescriptor parcelFileDescriptor = this.f8658a;
            try {
                Os.lseek(parcelFileDescriptor.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return parcelFileDescriptor;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
    }

    @RequiresApi(21)
    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.f8657a = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean isSupported() {
        return true;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    @RequiresApi(21)
    public ParcelFileDescriptor rewindAndGet() {
        return this.f8657a.rewind();
    }
}
