package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import p000.C1909vh;

/* loaded from: classes.dex */
public class DetailsOverviewRow extends Row {

    /* renamed from: d */
    public Object f5613d;

    /* renamed from: e */
    public Drawable f5614e;

    /* renamed from: f */
    public boolean f5615f;

    /* renamed from: g */
    public ArrayList f5616g;

    /* renamed from: h */
    public final C1909vh f5617h;

    /* renamed from: i */
    public ObjectAdapter f5618i;

    /* loaded from: classes.dex */
    public static class Listener {
        public void onActionsAdapterChanged(@NonNull DetailsOverviewRow detailsOverviewRow) {
        }

        public void onImageDrawableChanged(@NonNull DetailsOverviewRow detailsOverviewRow) {
        }

        public void onItemChanged(@NonNull DetailsOverviewRow detailsOverviewRow) {
        }
    }

    public DetailsOverviewRow(@NonNull Object obj) {
        super(null);
        this.f5615f = true;
        C1909vh c1909vh = new C1909vh();
        this.f5617h = c1909vh;
        this.f5618i = new ArrayObjectAdapter(c1909vh);
        this.f5613d = obj;
        if (obj != null) {
        } else {
            throw new IllegalArgumentException("Object cannot be null");
        }
    }

    /* renamed from: a */
    public final void m1385a(Listener listener) {
        if (this.f5616g == null) {
            this.f5616g = new ArrayList();
        } else {
            int i = 0;
            while (i < this.f5616g.size()) {
                Listener listener2 = (Listener) ((WeakReference) this.f5616g.get(i)).get();
                if (listener2 == null) {
                    this.f5616g.remove(i);
                } else if (listener2 == listener) {
                    return;
                } else {
                    i++;
                }
            }
        }
        this.f5616g.add(new WeakReference(listener));
    }

    @Deprecated
    public final void addAction(int i, Action action) {
        ((ArrayObjectAdapter) this.f5618i).add(i, action);
    }

    /* renamed from: b */
    public final void m1386b() {
        if (this.f5616g != null) {
            int i = 0;
            while (i < this.f5616g.size()) {
                Listener listener = (Listener) ((WeakReference) this.f5616g.get(i)).get();
                if (listener == null) {
                    this.f5616g.remove(i);
                } else {
                    listener.onImageDrawableChanged(this);
                    i++;
                }
            }
        }
    }

    /* renamed from: c */
    public final void m1387c(Listener listener) {
        if (this.f5616g != null) {
            int i = 0;
            while (i < this.f5616g.size()) {
                Listener listener2 = (Listener) ((WeakReference) this.f5616g.get(i)).get();
                if (listener2 == null) {
                    this.f5616g.remove(i);
                } else {
                    if (listener2 == listener) {
                        this.f5616g.remove(i);
                        return;
                    }
                    i++;
                }
            }
        }
    }

    @Nullable
    public Action getActionForKeyCode(int i) {
        ObjectAdapter actionsAdapter = getActionsAdapter();
        if (actionsAdapter != null) {
            for (int i2 = 0; i2 < actionsAdapter.size(); i2++) {
                Action action = (Action) actionsAdapter.get(i2);
                if (action.respondsToKeyCode(i)) {
                    return action;
                }
            }
            return null;
        }
        return null;
    }

    @Deprecated
    public final List<Action> getActions() {
        return ((ArrayObjectAdapter) this.f5618i).unmodifiableList();
    }

    @NonNull
    public final ObjectAdapter getActionsAdapter() {
        return this.f5618i;
    }

    @Nullable
    public final Drawable getImageDrawable() {
        return this.f5614e;
    }

    @NonNull
    public final Object getItem() {
        return this.f5613d;
    }

    public boolean isImageScaleUpAllowed() {
        return this.f5615f;
    }

    @Deprecated
    public final boolean removeAction(Action action) {
        return ((ArrayObjectAdapter) this.f5618i).remove(action);
    }

    public final void setActionsAdapter(@NonNull ObjectAdapter objectAdapter) {
        if (objectAdapter != this.f5618i) {
            this.f5618i = objectAdapter;
            if (objectAdapter.getPresenterSelector() == null) {
                this.f5618i.setPresenterSelector(this.f5617h);
            }
            if (this.f5616g != null) {
                int i = 0;
                while (i < this.f5616g.size()) {
                    Listener listener = (Listener) ((WeakReference) this.f5616g.get(i)).get();
                    if (listener == null) {
                        this.f5616g.remove(i);
                    } else {
                        listener.onActionsAdapterChanged(this);
                        i++;
                    }
                }
            }
        }
    }

    public final void setImageBitmap(@NonNull Context context, @NonNull Bitmap bitmap) {
        this.f5614e = new BitmapDrawable(context.getResources(), bitmap);
        m1386b();
    }

    public final void setImageDrawable(@Nullable Drawable drawable) {
        if (this.f5614e != drawable) {
            this.f5614e = drawable;
            m1386b();
        }
    }

    public void setImageScaleUpAllowed(boolean z) {
        if (z != this.f5615f) {
            this.f5615f = z;
            m1386b();
        }
    }

    public final void setItem(@NonNull Object obj) {
        if (obj != this.f5613d) {
            this.f5613d = obj;
            if (this.f5616g != null) {
                int i = 0;
                while (i < this.f5616g.size()) {
                    Listener listener = (Listener) ((WeakReference) this.f5616g.get(i)).get();
                    if (listener == null) {
                        this.f5616g.remove(i);
                    } else {
                        listener.onItemChanged(this);
                        i++;
                    }
                }
            }
        }
    }

    @Deprecated
    public final void addAction(Action action) {
        ((ArrayObjectAdapter) this.f5618i).add(action);
    }
}
