package p000;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

/* loaded from: classes.dex */
public final class e03 implements Resource {

    /* renamed from: a */
    public final Bitmap f16638a;

    public e03(Bitmap bitmap) {
        this.f16638a = bitmap;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Object get() {
        return this.f16638a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class getResourceClass() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return Util.getBitmapByteSize(this.f16638a);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void recycle() {
    }
}
