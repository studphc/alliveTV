package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m5569d2 = {"androidx/core/view/MenuKt$iterator$1", "", "Landroid/view/MenuItem;", "", "hasNext", "()Z", "next", "()Landroid/view/MenuItem;", "", "remove", "()V", "core-ktx_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt$iterator$1\n+ 2 Menu.kt\nandroidx/core/view/MenuKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n83#2:91\n1#3:92\n*S KotlinDebug\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt$iterator$1\n*L\n74#1:91\n74#1:92\n*E\n"})
/* loaded from: classes.dex */
public final class MenuKt$iterator$1 implements Iterator<MenuItem>, KMutableIterator {

    /* renamed from: a */
    public int f3890a;

    /* renamed from: b */
    public final /* synthetic */ Menu f3891b;

    public MenuKt$iterator$1(Menu menu) {
        this.f3891b = menu;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f3890a < this.f3891b.size()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        Unit unit;
        int i = this.f3890a - 1;
        this.f3890a = i;
        Menu menu = this.f3891b;
        MenuItem item = menu.getItem(i);
        if (item != null) {
            menu.removeItem(item.getItemId());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit != null) {
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public MenuItem next() {
        int i = this.f3890a;
        this.f3890a = i + 1;
        MenuItem item = this.f3891b.getItem(i);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }
}
