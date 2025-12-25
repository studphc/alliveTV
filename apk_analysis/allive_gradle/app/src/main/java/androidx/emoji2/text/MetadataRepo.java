package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.InputStream;
import java.nio.ByteBuffer;
import p000.ao1;
import p000.u00;
import p000.zn1;

@AnyThread
@RequiresApi(19)
/* loaded from: classes.dex */
public final class MetadataRepo {

    /* renamed from: a */
    public final MetadataList f4218a;

    /* renamed from: b */
    public final char[] f4219b;

    /* renamed from: c */
    public final ao1 f4220c = new ao1(1024);

    /* renamed from: d */
    public final Typeface f4221d;

    public MetadataRepo(Typeface typeface, MetadataList metadataList) {
        boolean z;
        this.f4221d = typeface;
        this.f4218a = metadataList;
        this.f4219b = new char[metadataList.listLength() * 2];
        int listLength = metadataList.listLength();
        for (int i = 0; i < listLength; i++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i);
            Character.toChars(typefaceEmojiRasterizer.getId(), this.f4219b, i * 2);
            Preconditions.checkNotNull(typefaceEmojiRasterizer, "emoji metadata cannot be null");
            if (typefaceEmojiRasterizer.getCodepointsLength() > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "invalid metadata codepoint length");
            this.f4220c.m1955a(typefaceEmojiRasterizer, 0, typefaceEmojiRasterizer.getCodepointsLength() - 1);
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static MetadataRepo create(@NonNull Typeface typeface) {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            return new MetadataRepo(typeface, new MetadataList());
        } finally {
            TraceCompat.endSection();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public char[] getEmojiCharArray() {
        return this.f4219b;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MetadataList getMetadataList() {
        return this.f4218a;
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface typeface, @NonNull InputStream inputStream) {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            return new MetadataRepo(typeface, zn1.m8418b(inputStream));
        } finally {
            TraceCompat.endSection();
        }
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface typeface, @NonNull ByteBuffer byteBuffer) {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.position((int) zn1.m8417a(new u00(duplicate, 2)).f27676a);
            return new MetadataRepo(typeface, MetadataList.getRootAsMetadataList(duplicate));
        } finally {
            TraceCompat.endSection();
        }
    }

    @NonNull
    public static MetadataRepo create(@NonNull AssetManager assetManager, @NonNull String str) {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            Typeface createFromAsset = Typeface.createFromAsset(assetManager, str);
            InputStream open = assetManager.open(str);
            try {
                MetadataList m8418b = zn1.m8418b(open);
                open.close();
                return new MetadataRepo(createFromAsset, m8418b);
            } finally {
            }
        } finally {
            TraceCompat.endSection();
        }
    }
}
