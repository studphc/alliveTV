package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m5569d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "", "hasNext", "()Z", "next", "()Landroid/view/View;", "", "remove", "()V", "core-ktx_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class ViewGroupKt$iterator$1 implements Iterator<View>, KMutableIterator {

    /* renamed from: a */
    public int f3921a;

    /* renamed from: b */
    public final /* synthetic */ ViewGroup f3922b;

    public ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.f3922b = viewGroup;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f3921a < this.f3922b.getChildCount()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        int i = this.f3921a - 1;
        this.f3921a = i;
        this.f3922b.removeViewAt(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public View next() {
        int i = this.f3921a;
        this.f3921a = i + 1;
        View childAt = this.f3922b.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }
}
