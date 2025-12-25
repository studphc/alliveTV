package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5569d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "", "hasNext", "()Z", "next", "()Landroid/graphics/Rect;", "core-ktx_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class RegionKt$iterator$1 implements Iterator<Rect>, KMappedMarker {

    /* renamed from: a */
    public final RegionIterator f3643a;

    /* renamed from: b */
    public final Rect f3644b;

    /* renamed from: c */
    public boolean f3645c;

    public RegionKt$iterator$1(Region region) {
        RegionIterator regionIterator = new RegionIterator(region);
        this.f3643a = regionIterator;
        Rect rect = new Rect();
        this.f3644b = rect;
        this.f3645c = regionIterator.next(rect);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3645c;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public Rect next() {
        if (this.f3645c) {
            Rect rect = this.f3644b;
            Rect rect2 = new Rect(rect);
            this.f3645c = this.f3643a.next(rect);
            return rect2;
        }
        throw new IndexOutOfBoundsException();
    }
}
