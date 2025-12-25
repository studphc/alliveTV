package p000;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class xq2 implements MenuItem.OnMenuItemClickListener {

    /* renamed from: d */
    public static final Class[] f28705d = {MenuItem.class};

    /* renamed from: a */
    public final /* synthetic */ int f28706a = 0;

    /* renamed from: b */
    public Object f28707b;

    /* renamed from: c */
    public Object f28708c;

    public /* synthetic */ xq2() {
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (this.f28706a) {
            case 0:
                Method method = (Method) this.f28708c;
                try {
                    Class<?> returnType = method.getReturnType();
                    Class<?> cls = Boolean.TYPE;
                    Object obj = this.f28707b;
                    if (returnType == cls) {
                        return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
                    }
                    method.invoke(obj, menuItem);
                    return true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            default:
                return ((MenuItem.OnMenuItemClickListener) this.f28707b).onMenuItemClick(((MenuItemWrapperICS) this.f28708c).m6346a(menuItem));
        }
    }

    public xq2(MenuItemWrapperICS menuItemWrapperICS, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f28708c = menuItemWrapperICS;
        this.f28707b = onMenuItemClickListener;
    }
}
