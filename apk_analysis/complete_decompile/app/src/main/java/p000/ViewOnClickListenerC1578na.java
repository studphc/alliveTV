package p000;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: na */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC1578na implements View.OnClickListener {

    /* renamed from: a */
    public final View f23305a;

    /* renamed from: b */
    public final String f23306b;

    /* renamed from: c */
    public Method f23307c;

    /* renamed from: d */
    public Context f23308d;

    public ViewOnClickListenerC1578na(View view, String str) {
        this.f23305a = view;
        this.f23306b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        if (this.f23307c == null) {
            View view2 = this.f23305a;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f23306b;
                if (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                            this.f23307c = method;
                            this.f23308d = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    if (context instanceof ContextWrapper) {
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        context = null;
                    }
                } else {
                    int id = view2.getId();
                    if (id == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    StringBuilder m7065u = AbstractC1726qj.m7065u("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                    m7065u.append(view2.getClass());
                    m7065u.append(str);
                    throw new IllegalStateException(m7065u.toString());
                }
            }
        }
        try {
            this.f23307c.invoke(this.f23308d, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
