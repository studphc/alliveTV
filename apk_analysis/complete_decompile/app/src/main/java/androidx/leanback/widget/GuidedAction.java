package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import java.util.List;

/* loaded from: classes.dex */
public class GuidedAction extends Action {
    public static final long ACTION_ID_CANCEL = -5;
    public static final long ACTION_ID_CONTINUE = -7;
    public static final long ACTION_ID_CURRENT = -3;
    public static final long ACTION_ID_FINISH = -6;
    public static final long ACTION_ID_NEXT = -2;
    public static final long ACTION_ID_NO = -9;
    public static final long ACTION_ID_OK = -4;
    public static final long ACTION_ID_YES = -8;
    public static final int CHECKBOX_CHECK_SET_ID = -1;
    public static final int DEFAULT_CHECK_SET_ID = 1;
    public static final int NO_CHECK_SET = 0;

    /* renamed from: f */
    public int f5734f;

    /* renamed from: g */
    public CharSequence f5735g;

    /* renamed from: h */
    public CharSequence f5736h;

    /* renamed from: i */
    public int f5737i;

    /* renamed from: j */
    public int f5738j;

    /* renamed from: k */
    public int f5739k;

    /* renamed from: l */
    public int f5740l;

    /* renamed from: m */
    public int f5741m;

    /* renamed from: n */
    public String[] f5742n;

    /* renamed from: o */
    public int f5743o;

    /* renamed from: p */
    public List f5744p;

    /* renamed from: q */
    public Intent f5745q;

    /* loaded from: classes.dex */
    public static class Builder extends BuilderBase<Builder> {
        @Deprecated
        public Builder() {
            super(null);
        }

        @NonNull
        public GuidedAction build() {
            GuidedAction guidedAction = new GuidedAction();
            applyValues(guidedAction);
            return guidedAction;
        }

        public Builder(@Nullable Context context) {
            super(context);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class BuilderBase<B extends BuilderBase> {

        /* renamed from: a */
        public final Context f5746a;

        /* renamed from: b */
        public long f5747b;

        /* renamed from: c */
        public CharSequence f5748c;

        /* renamed from: d */
        public CharSequence f5749d;

        /* renamed from: e */
        public CharSequence f5750e;

        /* renamed from: f */
        public CharSequence f5751f;

        /* renamed from: g */
        public String[] f5752g;

        /* renamed from: h */
        public Drawable f5753h;

        /* renamed from: p */
        public List f5761p;

        /* renamed from: q */
        public Intent f5762q;

        /* renamed from: j */
        public int f5755j = 0;

        /* renamed from: k */
        public int f5756k = 524289;

        /* renamed from: l */
        public int f5757l = 524289;

        /* renamed from: m */
        public int f5758m = 1;

        /* renamed from: n */
        public int f5759n = 1;

        /* renamed from: o */
        public int f5760o = 0;

        /* renamed from: i */
        public int f5754i = 112;

        public BuilderBase(@NonNull Context context) {
            this.f5746a = context;
        }

        /* renamed from: a */
        public final void m1436a(int i, int i2) {
            this.f5754i = (i & i2) | (this.f5754i & (~i2));
        }

        public final void applyValues(@NonNull GuidedAction guidedAction) {
            guidedAction.setId(this.f5747b);
            guidedAction.setLabel1(this.f5748c);
            guidedAction.setEditTitle(this.f5749d);
            guidedAction.setLabel2(this.f5750e);
            guidedAction.setEditDescription(this.f5751f);
            guidedAction.setIcon(this.f5753h);
            guidedAction.f5745q = this.f5762q;
            guidedAction.f5737i = this.f5755j;
            guidedAction.f5738j = this.f5756k;
            guidedAction.f5739k = this.f5757l;
            guidedAction.f5742n = this.f5752g;
            guidedAction.f5740l = this.f5758m;
            guidedAction.f5741m = this.f5759n;
            guidedAction.f5734f = this.f5754i;
            guidedAction.f5743o = this.f5760o;
            guidedAction.f5744p = this.f5761p;
        }

        public B autoSaveRestoreEnabled(boolean z) {
            int i;
            if (z) {
                i = 64;
            } else {
                i = 0;
            }
            m1436a(i, 64);
            return this;
        }

        public B autofillHints(@Nullable String... strArr) {
            this.f5752g = strArr;
            return this;
        }

        public B checkSetId(int i) {
            this.f5760o = i;
            if (this.f5755j == 0) {
                return this;
            }
            throw new IllegalArgumentException("Editable actions cannot also be in check sets");
        }

        public B checked(boolean z) {
            m1436a(z ? 1 : 0, 1);
            if (this.f5755j == 0) {
                return this;
            }
            throw new IllegalArgumentException("Editable actions cannot also be checked");
        }

        public B clickAction(long j) {
            Context context = this.f5746a;
            if (j == -4) {
                this.f5747b = -4L;
                this.f5748c = context.getString(android.R.string.ok);
            } else if (j == -5) {
                this.f5747b = -5L;
                this.f5748c = context.getString(android.R.string.cancel);
            } else if (j == -6) {
                this.f5747b = -6L;
                this.f5748c = context.getString(androidx.leanback.R.string.lb_guidedaction_finish_title);
            } else if (j == -7) {
                this.f5747b = -7L;
                this.f5748c = context.getString(androidx.leanback.R.string.lb_guidedaction_continue_title);
            } else if (j == -8) {
                this.f5747b = -8L;
                this.f5748c = context.getString(android.R.string.ok);
            } else if (j == -9) {
                this.f5747b = -9L;
                this.f5748c = context.getString(android.R.string.cancel);
            }
            return this;
        }

        public B description(@Nullable CharSequence charSequence) {
            this.f5750e = charSequence;
            return this;
        }

        public B descriptionEditInputType(int i) {
            this.f5759n = i;
            return this;
        }

        public B descriptionEditable(boolean z) {
            if (!z) {
                if (this.f5755j == 2) {
                    this.f5755j = 0;
                }
                return this;
            }
            this.f5755j = 2;
            if ((this.f5754i & 1) != 1 && this.f5760o == 0) {
                return this;
            }
            throw new IllegalArgumentException("Editable actions cannot also be checked");
        }

        public B descriptionInputType(int i) {
            this.f5757l = i;
            return this;
        }

        public B editDescription(@Nullable CharSequence charSequence) {
            this.f5751f = charSequence;
            return this;
        }

        public B editInputType(int i) {
            this.f5758m = i;
            return this;
        }

        public B editTitle(@Nullable CharSequence charSequence) {
            this.f5749d = charSequence;
            return this;
        }

        public B editable(boolean z) {
            if (!z) {
                if (this.f5755j == 1) {
                    this.f5755j = 0;
                }
                return this;
            }
            this.f5755j = 1;
            if ((this.f5754i & 1) != 1 && this.f5760o == 0) {
                return this;
            }
            throw new IllegalArgumentException("Editable actions cannot also be checked");
        }

        public B enabled(boolean z) {
            int i;
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
            m1436a(i, 16);
            return this;
        }

        public B focusable(boolean z) {
            int i;
            if (z) {
                i = 32;
            } else {
                i = 0;
            }
            m1436a(i, 32);
            return this;
        }

        @NonNull
        public Context getContext() {
            return this.f5746a;
        }

        public B hasEditableActivatorView(boolean z) {
            if (!z) {
                if (this.f5755j == 3) {
                    this.f5755j = 0;
                }
                return this;
            }
            this.f5755j = 3;
            if ((this.f5754i & 1) != 1 && this.f5760o == 0) {
                return this;
            }
            throw new IllegalArgumentException("Editable actions cannot also be checked");
        }

        public B hasNext(boolean z) {
            int i;
            if (z) {
                i = 4;
            } else {
                i = 0;
            }
            m1436a(i, 4);
            return this;
        }

        public B icon(@Nullable Drawable drawable) {
            this.f5753h = drawable;
            return this;
        }

        @Deprecated
        public B iconResourceId(@DrawableRes int i, Context context) {
            return icon(ContextCompat.getDrawable(context, i));
        }

        /* renamed from: id */
        public B m1437id(long j) {
            this.f5747b = j;
            return this;
        }

        public B infoOnly(boolean z) {
            int i;
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            m1436a(i, 8);
            return this;
        }

        public B inputType(int i) {
            this.f5756k = i;
            return this;
        }

        public B intent(@Nullable Intent intent) {
            this.f5762q = intent;
            return this;
        }

        public B multilineDescription(boolean z) {
            int i;
            if (z) {
                i = 2;
            } else {
                i = 0;
            }
            m1436a(i, 2);
            return this;
        }

        public B subActions(@Nullable List<GuidedAction> list) {
            this.f5761p = list;
            return this;
        }

        public B title(@Nullable CharSequence charSequence) {
            this.f5748c = charSequence;
            return this;
        }

        public B description(@StringRes int i) {
            this.f5750e = getContext().getString(i);
            return this;
        }

        public B editDescription(@StringRes int i) {
            this.f5751f = getContext().getString(i);
            return this;
        }

        public B editTitle(@StringRes int i) {
            this.f5749d = getContext().getString(i);
            return this;
        }

        public B icon(@DrawableRes int i) {
            return icon(ContextCompat.getDrawable(getContext(), i));
        }

        public B title(@StringRes int i) {
            this.f5748c = getContext().getString(i);
            return this;
        }
    }

    public GuidedAction() {
        super(0L);
    }

    public String[] getAutofillHints() {
        return this.f5742n;
    }

    public int getCheckSetId() {
        return this.f5743o;
    }

    @Nullable
    public CharSequence getDescription() {
        return getLabel2();
    }

    public int getDescriptionEditInputType() {
        return this.f5741m;
    }

    public int getDescriptionInputType() {
        return this.f5739k;
    }

    @Nullable
    public CharSequence getEditDescription() {
        return this.f5736h;
    }

    public int getEditInputType() {
        return this.f5740l;
    }

    @Nullable
    public CharSequence getEditTitle() {
        return this.f5735g;
    }

    public int getInputType() {
        return this.f5738j;
    }

    @Nullable
    public Intent getIntent() {
        return this.f5745q;
    }

    @Nullable
    @SuppressLint({"NullableCollection"})
    public List<GuidedAction> getSubActions() {
        return this.f5744p;
    }

    @Nullable
    public CharSequence getTitle() {
        return getLabel1();
    }

    public boolean hasEditableActivatorView() {
        if (this.f5737i == 3) {
            return true;
        }
        return false;
    }

    public boolean hasMultilineDescription() {
        if ((this.f5734f & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if ((this.f5734f & 4) == 4) {
            return true;
        }
        return false;
    }

    public boolean hasSubActions() {
        if (this.f5744p != null) {
            return true;
        }
        return false;
    }

    public boolean hasTextEditable() {
        int i = this.f5737i;
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    public boolean infoOnly() {
        if ((this.f5734f & 8) == 8) {
            return true;
        }
        return false;
    }

    public final boolean isAutoSaveRestoreEnabled() {
        if ((this.f5734f & 64) == 64) {
            return true;
        }
        return false;
    }

    public boolean isChecked() {
        if ((this.f5734f & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean isDescriptionEditable() {
        if (this.f5737i == 2) {
            return true;
        }
        return false;
    }

    public boolean isEditTitleUsed() {
        if (this.f5735g != null) {
            return true;
        }
        return false;
    }

    public boolean isEditable() {
        if (this.f5737i == 1) {
            return true;
        }
        return false;
    }

    public boolean isEnabled() {
        if ((this.f5734f & 16) == 16) {
            return true;
        }
        return false;
    }

    public boolean isFocusable() {
        if ((this.f5734f & 32) == 32) {
            return true;
        }
        return false;
    }

    public void onRestoreInstanceState(@NonNull Bundle bundle, @NonNull String str) {
        int descriptionEditInputType;
        int editInputType;
        if (isEditable() && (editInputType = getEditInputType() & 4080) != 128 && editInputType != 144 && editInputType != 224) {
            String string = bundle.getString(str);
            if (string != null) {
                setTitle(string);
                return;
            }
            return;
        }
        if (isDescriptionEditable() && (descriptionEditInputType = getDescriptionEditInputType() & 4080) != 128 && descriptionEditInputType != 144 && descriptionEditInputType != 224) {
            String string2 = bundle.getString(str);
            if (string2 != null) {
                setDescription(string2);
                return;
            }
            return;
        }
        if (getCheckSetId() != 0) {
            setChecked(bundle.getBoolean(str, isChecked()));
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle, @NonNull String str) {
        int descriptionEditInputType;
        int editInputType;
        if (isEditable() && (editInputType = getEditInputType() & 4080) != 128 && editInputType != 144 && editInputType != 224 && getTitle() != null) {
            bundle.putString(str, getTitle().toString());
            return;
        }
        if (isDescriptionEditable() && (descriptionEditInputType = getDescriptionEditInputType() & 4080) != 128 && descriptionEditInputType != 144 && descriptionEditInputType != 224 && getDescription() != null) {
            bundle.putString(str, getDescription().toString());
        } else if (getCheckSetId() != 0) {
            bundle.putBoolean(str, isChecked());
        }
    }

    public void setChecked(boolean z) {
        this.f5734f = (z ? 1 : 0) | (this.f5734f & (-2));
    }

    public void setDescription(@Nullable CharSequence charSequence) {
        setLabel2(charSequence);
    }

    public void setEditDescription(@Nullable CharSequence charSequence) {
        this.f5736h = charSequence;
    }

    public void setEditTitle(@Nullable CharSequence charSequence) {
        this.f5735g = charSequence;
    }

    public void setEnabled(boolean z) {
        int i;
        if (z) {
            i = 16;
        } else {
            i = 0;
        }
        this.f5734f = (i & 16) | (this.f5734f & (-17));
    }

    public void setFocusable(boolean z) {
        int i;
        if (z) {
            i = 32;
        } else {
            i = 0;
        }
        this.f5734f = (i & 32) | (this.f5734f & (-33));
    }

    public void setIntent(@Nullable Intent intent) {
        this.f5745q = intent;
    }

    public void setSubActions(@Nullable List<GuidedAction> list) {
        this.f5744p = list;
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        setLabel1(charSequence);
    }
}
