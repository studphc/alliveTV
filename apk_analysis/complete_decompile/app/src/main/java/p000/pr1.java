package p000;

import com.bumptech.glide.load.resource.drawable.DrawableResource;

/* loaded from: classes.dex */
public final class pr1 extends DrawableResource {
    @Override // com.bumptech.glide.load.engine.Resource
    public final Class getResourceClass() {
        return this.drawable.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return Math.max(1, this.drawable.getIntrinsicHeight() * this.drawable.getIntrinsicWidth() * 4);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void recycle() {
    }
}
