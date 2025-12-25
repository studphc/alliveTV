package androidx.leanback.widget;

import android.util.Pair;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.GuidedActionAdapter;
import androidx.leanback.widget.GuidedActionsStylist;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class GuidedActionAdapterGroup {

    /* renamed from: a */
    public final ArrayList f5775a = new ArrayList();

    /* renamed from: b */
    public boolean f5776b;

    /* renamed from: c */
    public GuidedActionAdapter.EditListener f5777c;

    /* renamed from: a */
    public static void m1439a(GuidedActionsStylist.ViewHolder viewHolder, TextView textView) {
        GuidedAction action = viewHolder.getAction();
        if (textView == viewHolder.getDescriptionView()) {
            if (action.getEditDescription() != null) {
                action.setEditDescription(textView.getText());
                return;
            } else {
                action.setDescription(textView.getText());
                return;
            }
        }
        if (textView == viewHolder.getTitleView()) {
            if (action.getEditTitle() != null) {
                action.setEditTitle(textView.getText());
            } else {
                action.setTitle(textView.getText());
            }
        }
    }

    public void addAdpter(@Nullable GuidedActionAdapter guidedActionAdapter, @Nullable GuidedActionAdapter guidedActionAdapter2) {
        this.f5775a.add(new Pair(guidedActionAdapter, guidedActionAdapter2));
        if (guidedActionAdapter != null) {
            guidedActionAdapter.f5772m = this;
        }
        if (guidedActionAdapter2 != null) {
            guidedActionAdapter2.f5772m = this;
        }
    }

    public void closeIme(@NonNull View view) {
        if (this.f5776b) {
            this.f5776b = false;
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            this.f5777c.onImeClose();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0043, code lost:
    
        r3 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fillAndGoNext(@NonNull GuidedActionAdapter guidedActionAdapter, @NonNull TextView textView) {
        int i;
        GuidedActionsStylist.ViewHolder findSubChildViewHolder = guidedActionAdapter.findSubChildViewHolder(textView);
        m1439a(findSubChildViewHolder, textView);
        guidedActionAdapter.performOnActionClick(findSubChildViewHolder);
        long onGuidedActionEditedAndProceed = this.f5777c.onGuidedActionEditedAndProceed(findSubChildViewHolder.getAction());
        guidedActionAdapter.getGuidedActionsStylist().m1442c(findSubChildViewHolder, false, true);
        if (onGuidedActionEditedAndProceed != -3 && onGuidedActionEditedAndProceed != findSubChildViewHolder.getAction().getId()) {
            GuidedAction action = findSubChildViewHolder.getAction();
            if (onGuidedActionEditedAndProceed == -2) {
                int indexOf = guidedActionAdapter.indexOf(action);
                if (indexOf >= 0) {
                    i = indexOf + 1;
                    while (true) {
                        int count = guidedActionAdapter.getCount();
                        if (onGuidedActionEditedAndProceed == -2) {
                            while (i < count && !guidedActionAdapter.getItem(i).isFocusable()) {
                                i++;
                            }
                        } else {
                            while (i < count && guidedActionAdapter.getItem(i).getId() != onGuidedActionEditedAndProceed) {
                                i++;
                            }
                        }
                        if (i < count) {
                            GuidedActionsStylist.ViewHolder viewHolder = (GuidedActionsStylist.ViewHolder) guidedActionAdapter.getGuidedActionsStylist().getActionsGridView().findViewHolderForPosition(i);
                            if (viewHolder != null) {
                                if (viewHolder.getAction().hasTextEditable()) {
                                    openIme(guidedActionAdapter, viewHolder);
                                    return;
                                } else {
                                    closeIme(viewHolder.itemView);
                                    viewHolder.itemView.requestFocus();
                                    return;
                                }
                            }
                        } else {
                            guidedActionAdapter = getNextAdapter(guidedActionAdapter);
                            if (guidedActionAdapter == null) {
                                break;
                            }
                        }
                        i = 0;
                    }
                }
            }
            i = 0;
        }
        closeIme(textView);
        findSubChildViewHolder.itemView.requestFocus();
    }

    public void fillAndStay(@NonNull GuidedActionAdapter guidedActionAdapter, @NonNull TextView textView) {
        GuidedActionsStylist.ViewHolder findSubChildViewHolder = guidedActionAdapter.findSubChildViewHolder(textView);
        m1439a(findSubChildViewHolder, textView);
        this.f5777c.onGuidedActionEditCanceled(findSubChildViewHolder.getAction());
        guidedActionAdapter.getGuidedActionsStylist().m1442c(findSubChildViewHolder, false, true);
        closeIme(textView);
        findSubChildViewHolder.itemView.requestFocus();
    }

    @Nullable
    public GuidedActionAdapter getNextAdapter(@NonNull GuidedActionAdapter guidedActionAdapter) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f5775a;
            if (i < arrayList.size()) {
                Pair pair = (Pair) arrayList.get(i);
                if (pair.first == guidedActionAdapter) {
                    return (GuidedActionAdapter) pair.second;
                }
                i++;
            } else {
                return null;
            }
        }
    }

    public void openIme(@NonNull GuidedActionAdapter guidedActionAdapter, @NonNull GuidedActionsStylist.ViewHolder viewHolder) {
        guidedActionAdapter.getGuidedActionsStylist().m1442c(viewHolder, true, true);
        View editingView = viewHolder.getEditingView();
        if (editingView != null && viewHolder.isInEditingText()) {
            InputMethodManager inputMethodManager = (InputMethodManager) editingView.getContext().getSystemService("input_method");
            editingView.setFocusable(true);
            editingView.requestFocus();
            inputMethodManager.showSoftInput(editingView, 0);
            if (!this.f5776b) {
                this.f5776b = true;
                this.f5777c.onImeOpen();
            }
        }
    }

    public void setEditListener(@Nullable GuidedActionAdapter.EditListener editListener) {
        this.f5777c = editListener;
    }
}
