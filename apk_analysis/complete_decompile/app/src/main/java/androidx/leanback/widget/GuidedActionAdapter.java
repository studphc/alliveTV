package androidx.leanback.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.GuidedActionsStylist;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import p000.fy0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class GuidedActionAdapter extends RecyclerView.Adapter {

    /* renamed from: d */
    public final VerticalGridView f5763d;

    /* renamed from: e */
    public final boolean f5764e;

    /* renamed from: f */
    public final ViewOnKeyListenerC0400w0 f5765f;

    /* renamed from: g */
    public final ViewOnFocusChangeListenerC0396v0 f5766g;

    /* renamed from: h */
    public final C0392u0 f5767h;

    /* renamed from: i */
    public final C0388t0 f5768i;

    /* renamed from: j */
    public final ArrayList f5769j;

    /* renamed from: k */
    public ClickListener f5770k;

    /* renamed from: l */
    public final GuidedActionsStylist f5771l;

    /* renamed from: m */
    public GuidedActionAdapterGroup f5772m;

    /* renamed from: n */
    public DiffCallback f5773n;

    /* renamed from: o */
    public final ViewOnClickListenerC0384s0 f5774o = new ViewOnClickListenerC0384s0(this);

    /* loaded from: classes.dex */
    public interface ClickListener {
        void onGuidedActionClicked(GuidedAction guidedAction);
    }

    /* loaded from: classes.dex */
    public interface EditListener {
        void onGuidedActionEditCanceled(@NonNull GuidedAction guidedAction);

        long onGuidedActionEditedAndProceed(@NonNull GuidedAction guidedAction);

        void onImeClose();

        void onImeOpen();
    }

    /* loaded from: classes.dex */
    public interface FocusListener {
        void onGuidedActionFocused(@NonNull GuidedAction guidedAction);
    }

    public GuidedActionAdapter(List<GuidedAction> list, ClickListener clickListener, FocusListener focusListener, GuidedActionsStylist guidedActionsStylist, boolean z) {
        ArrayList arrayList;
        VerticalGridView actionsGridView;
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(list);
        }
        this.f5769j = arrayList;
        this.f5770k = clickListener;
        this.f5771l = guidedActionsStylist;
        this.f5765f = new ViewOnKeyListenerC0400w0(this);
        this.f5766g = new ViewOnFocusChangeListenerC0396v0(this, focusListener);
        this.f5767h = new C0392u0(this);
        this.f5768i = new C0388t0(this);
        this.f5764e = z;
        if (!z) {
            this.f5773n = GuidedActionDiffCallback.getInstance();
        }
        if (z) {
            actionsGridView = guidedActionsStylist.getSubActionsGridView();
        } else {
            actionsGridView = guidedActionsStylist.getActionsGridView();
        }
        this.f5763d = actionsGridView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final void m1438a(EditText editText) {
        if (editText != 0) {
            editText.setPrivateImeOptions("escapeNorth");
            C0392u0 c0392u0 = this.f5767h;
            editText.setOnEditorActionListener(c0392u0);
            if (editText instanceof ImeKeyMonitor) {
                ((ImeKeyMonitor) editText).setImeKeyListener(c0392u0);
            }
            if (editText instanceof GuidedActionAutofillSupport) {
                ((GuidedActionAutofillSupport) editText).setOnAutofillListener(this.f5768i);
            }
        }
    }

    public GuidedActionsStylist.ViewHolder findSubChildViewHolder(View view) {
        VerticalGridView verticalGridView = this.f5763d;
        if (!verticalGridView.isAttachedToWindow()) {
            return null;
        }
        ViewParent parent = view.getParent();
        while (parent != verticalGridView && parent != null) {
            view = parent;
            parent = parent.getParent();
        }
        if (parent == null) {
            return null;
        }
        return (GuidedActionsStylist.ViewHolder) verticalGridView.getChildViewHolder(view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public List<GuidedAction> getActions() {
        return new ArrayList(this.f5769j);
    }

    public int getCount() {
        return this.f5769j.size();
    }

    public GuidedActionsStylist getGuidedActionsStylist() {
        return this.f5771l;
    }

    public GuidedAction getItem(int i) {
        return (GuidedAction) this.f5769j.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f5769j.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.f5771l.getItemViewType((GuidedAction) this.f5769j.get(i));
    }

    public void handleCheckedActions(GuidedActionsStylist.ViewHolder viewHolder) {
        GuidedAction action = viewHolder.getAction();
        int checkSetId = action.getCheckSetId();
        VerticalGridView verticalGridView = this.f5763d;
        if (verticalGridView.isAttachedToWindow() && checkSetId != 0) {
            GuidedActionsStylist guidedActionsStylist = this.f5771l;
            if (checkSetId != -1) {
                ArrayList arrayList = this.f5769j;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    GuidedAction guidedAction = (GuidedAction) arrayList.get(i);
                    if (guidedAction != action && guidedAction.getCheckSetId() == checkSetId && guidedAction.isChecked()) {
                        guidedAction.setChecked(false);
                        GuidedActionsStylist.ViewHolder viewHolder2 = (GuidedActionsStylist.ViewHolder) verticalGridView.findViewHolderForPosition(i);
                        if (viewHolder2 != null) {
                            guidedActionsStylist.onAnimateItemChecked(viewHolder2, false);
                        }
                    }
                }
            }
            if (!action.isChecked()) {
                action.setChecked(true);
                guidedActionsStylist.onAnimateItemChecked(viewHolder, true);
            } else if (checkSetId == -1) {
                action.setChecked(false);
                guidedActionsStylist.onAnimateItemChecked(viewHolder, false);
            }
        }
    }

    public int indexOf(GuidedAction guidedAction) {
        return this.f5769j.indexOf(guidedAction);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ArrayList arrayList = this.f5769j;
        if (i >= arrayList.size()) {
            return;
        }
        GuidedAction guidedAction = (GuidedAction) arrayList.get(i);
        this.f5771l.onBindViewHolder((GuidedActionsStylist.ViewHolder) viewHolder, guidedAction);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        GuidedActionsStylist.ViewHolder onCreateViewHolder = this.f5771l.onCreateViewHolder(viewGroup, i);
        View view = onCreateViewHolder.itemView;
        view.setOnKeyListener(this.f5765f);
        view.setOnClickListener(this.f5774o);
        view.setOnFocusChangeListener(this.f5766g);
        m1438a(onCreateViewHolder.getEditableTitleView());
        m1438a(onCreateViewHolder.getEditableDescriptionView());
        return onCreateViewHolder;
    }

    public void performOnActionClick(GuidedActionsStylist.ViewHolder viewHolder) {
        ClickListener clickListener = this.f5770k;
        if (clickListener != null) {
            clickListener.onGuidedActionClicked(viewHolder.getAction());
        }
    }

    public void setActions(List<GuidedAction> list) {
        if (!this.f5764e) {
            this.f5771l.collapseAction(false);
        }
        ViewOnFocusChangeListenerC0396v0 viewOnFocusChangeListenerC0396v0 = this.f5766g;
        if (viewOnFocusChangeListenerC0396v0.f6425b != null) {
            GuidedActionAdapter guidedActionAdapter = viewOnFocusChangeListenerC0396v0.f6426c;
            if (guidedActionAdapter.f5763d.isAttachedToWindow()) {
                RecyclerView.ViewHolder childViewHolder = guidedActionAdapter.f5763d.getChildViewHolder(viewOnFocusChangeListenerC0396v0.f6425b);
                if (childViewHolder != null) {
                    guidedActionAdapter.f5771l.onAnimateItemFocused((GuidedActionsStylist.ViewHolder) childViewHolder, false);
                } else {
                    Log.w("GuidedActionAdapter", "RecyclerView returned null view holder", new Throwable());
                }
            }
        }
        DiffCallback diffCallback = this.f5773n;
        ArrayList arrayList = this.f5769j;
        if (diffCallback != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            arrayList.clear();
            arrayList.addAll(list);
            DiffUtil.calculateDiff(new fy0(this, arrayList2)).dispatchUpdatesTo(this);
            return;
        }
        arrayList.clear();
        arrayList.addAll(list);
        notifyDataSetChanged();
    }

    public void setClickListener(ClickListener clickListener) {
        this.f5770k = clickListener;
    }

    public void setDiffCallback(DiffCallback<GuidedAction> diffCallback) {
        this.f5773n = diffCallback;
    }

    public void setFocusListener(FocusListener focusListener) {
        this.f5766g.f6424a = focusListener;
    }
}
