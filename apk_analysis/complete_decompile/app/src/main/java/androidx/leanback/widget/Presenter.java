package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Presenter implements FacetProvider {

    /* renamed from: a */
    public ArrayMap f6069a;

    /* loaded from: classes.dex */
    public static class ViewHolder implements FacetProvider {

        /* renamed from: a */
        public ArrayMap f6070a;
        public final View view;

        public ViewHolder(View view) {
            this.view = view;
        }

        @Override // androidx.leanback.widget.FacetProvider
        public final Object getFacet(Class<?> cls) {
            ArrayMap arrayMap = this.f6070a;
            if (arrayMap == null) {
                return null;
            }
            return arrayMap.get(cls);
        }

        public final void setFacet(Class<?> cls, Object obj) {
            if (this.f6070a == null) {
                this.f6070a = new ArrayMap();
            }
            this.f6070a.put(cls, obj);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewHolderTask {
        public void run(ViewHolder viewHolder) {
        }
    }

    public static void cancelAnimationsRecursive(View view) {
        if (view != null && view.hasTransientState()) {
            view.animate().cancel();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; view.hasTransientState() && i < childCount; i++) {
                    cancelAnimationsRecursive(viewGroup.getChildAt(i));
                }
            }
        }
    }

    @Override // androidx.leanback.widget.FacetProvider
    public final Object getFacet(Class<?> cls) {
        ArrayMap arrayMap = this.f6069a;
        if (arrayMap == null) {
            return null;
        }
        return arrayMap.get(cls);
    }

    public abstract void onBindViewHolder(@NonNull ViewHolder viewHolder, @Nullable Object obj);

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @NonNull Object obj, @NonNull List<Object> list) {
        onBindViewHolder(viewHolder, obj);
    }

    @NonNull
    public abstract ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup);

    public abstract void onUnbindViewHolder(@NonNull ViewHolder viewHolder);

    public void onViewAttachedToWindow(@NonNull ViewHolder viewHolder) {
    }

    public void onViewDetachedFromWindow(@NonNull ViewHolder viewHolder) {
        cancelAnimationsRecursive(viewHolder.view);
    }

    public final void setFacet(Class<?> cls, Object obj) {
        if (this.f6069a == null) {
            this.f6069a = new ArrayMap();
        }
        this.f6069a.put(cls, obj);
    }

    public void setOnClickListener(ViewHolder viewHolder, View.OnClickListener onClickListener) {
        viewHolder.view.setOnClickListener(onClickListener);
    }
}
