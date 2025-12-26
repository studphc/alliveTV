package androidx.leanback.widget;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class ClassPresenterSelector extends PresenterSelector {

    /* renamed from: a */
    public final ArrayList f5600a = new ArrayList();

    /* renamed from: b */
    public final HashMap f5601b = new HashMap();

    public ClassPresenterSelector addClassPresenter(Class<?> cls, Presenter presenter) {
        this.f5601b.put(cls, presenter);
        ArrayList arrayList = this.f5600a;
        if (!arrayList.contains(presenter)) {
            arrayList.add(presenter);
        }
        return this;
    }

    public ClassPresenterSelector addClassPresenterSelector(Class<?> cls, PresenterSelector presenterSelector) {
        this.f5601b.put(cls, presenterSelector);
        Presenter[] presenters = presenterSelector.getPresenters();
        for (int i = 0; i < presenters.length; i++) {
            ArrayList arrayList = this.f5600a;
            if (!arrayList.contains(presenters[i])) {
                arrayList.add(presenters[i]);
            }
        }
        return this;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    @Nullable
    public Presenter getPresenter(@Nullable Object obj) {
        Object obj2;
        Presenter presenter;
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        do {
            obj2 = this.f5601b.get(cls);
            if ((obj2 instanceof PresenterSelector) && (presenter = ((PresenterSelector) obj2).getPresenter(obj)) != null) {
                return presenter;
            }
            cls = cls.getSuperclass();
            if (obj2 != null) {
                break;
            }
        } while (cls != null);
        return (Presenter) obj2;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter[] getPresenters() {
        ArrayList arrayList = this.f5600a;
        return (Presenter[]) arrayList.toArray(new Presenter[arrayList.size()]);
    }
}
