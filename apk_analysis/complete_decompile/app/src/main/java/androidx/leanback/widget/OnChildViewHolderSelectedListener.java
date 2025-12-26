package androidx.leanback.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

@SuppressLint({"ListenerInterface"})
/* loaded from: classes.dex */
public abstract class OnChildViewHolderSelectedListener {
    public void onChildViewHolderSelected(@NonNull RecyclerView recyclerView, @Nullable RecyclerView.ViewHolder viewHolder, int i, int i2) {
    }

    public void onChildViewHolderSelectedAndPositioned(@NonNull RecyclerView recyclerView, @Nullable RecyclerView.ViewHolder viewHolder, int i, int i2) {
    }
}
