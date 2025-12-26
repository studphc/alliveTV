package androidx.leanback.widget;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class GuidedActionDiffCallback extends DiffCallback<GuidedAction> {

    /* renamed from: a */
    public static final GuidedActionDiffCallback f5782a = new GuidedActionDiffCallback();

    @NonNull
    public static GuidedActionDiffCallback getInstance() {
        return f5782a;
    }

    @Override // androidx.leanback.widget.DiffCallback
    public boolean areContentsTheSame(@NonNull GuidedAction guidedAction, @NonNull GuidedAction guidedAction2) {
        if (guidedAction == null) {
            return guidedAction2 == null;
        }
        if (guidedAction2 == null) {
            return false;
        }
        return guidedAction.getCheckSetId() == guidedAction2.getCheckSetId() && guidedAction.f5734f == guidedAction2.f5734f && TextUtils.equals(guidedAction.getTitle(), guidedAction2.getTitle()) && TextUtils.equals(guidedAction.getDescription(), guidedAction2.getDescription()) && guidedAction.getInputType() == guidedAction2.getInputType() && TextUtils.equals(guidedAction.getEditTitle(), guidedAction2.getEditTitle()) && TextUtils.equals(guidedAction.getEditDescription(), guidedAction2.getEditDescription()) && guidedAction.getEditInputType() == guidedAction2.getEditInputType() && guidedAction.getDescriptionEditInputType() == guidedAction2.getDescriptionEditInputType();
    }

    @Override // androidx.leanback.widget.DiffCallback
    public boolean areItemsTheSame(@NonNull GuidedAction guidedAction, @NonNull GuidedAction guidedAction2) {
        return guidedAction == null ? guidedAction2 == null : guidedAction2 != null && guidedAction.getId() == guidedAction2.getId();
    }
}
