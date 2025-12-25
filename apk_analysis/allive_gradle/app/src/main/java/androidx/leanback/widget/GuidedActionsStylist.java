package androidx.leanback.widget;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.GuidedActionAdapter;
import androidx.leanback.widget.ItemAlignmentFacet;
import androidx.leanback.widget.picker.DatePicker;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import p000.b01;
import p000.hy0;
import p000.ye0;

/* loaded from: classes.dex */
public class GuidedActionsStylist implements FragmentAnimationProvider {
    public static final int VIEW_TYPE_DATE_PICKER = 1;
    public static final int VIEW_TYPE_DEFAULT = 0;

    /* renamed from: x */
    public static final ItemAlignmentFacet f5791x;

    /* renamed from: a */
    public ViewGroup f5792a;

    /* renamed from: b */
    public VerticalGridView f5793b;

    /* renamed from: c */
    public VerticalGridView f5794c;

    /* renamed from: d */
    public View f5795d;

    /* renamed from: e */
    public View f5796e;

    /* renamed from: f */
    public boolean f5797f;

    /* renamed from: g */
    public float f5798g;

    /* renamed from: h */
    public float f5799h;

    /* renamed from: i */
    public float f5800i;

    /* renamed from: j */
    public float f5801j;

    /* renamed from: k */
    public float f5802k;

    /* renamed from: l */
    public float f5803l;

    /* renamed from: m */
    public int f5804m;

    /* renamed from: n */
    public int f5805n;

    /* renamed from: o */
    public int f5806o;

    /* renamed from: p */
    public int f5807p;

    /* renamed from: q */
    public int f5808q;

    /* renamed from: r */
    public GuidedActionAdapter.EditListener f5809r;

    /* renamed from: t */
    public Object f5811t;

    /* renamed from: w */
    public float f5814w;

    /* renamed from: s */
    public GuidedAction f5810s = null;

    /* renamed from: u */
    public boolean f5812u = true;

    /* renamed from: v */
    public boolean f5813v = true;

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder implements FacetProvider {

        /* renamed from: A */
        public final ImageView f5815A;

        /* renamed from: B */
        public int f5816B;

        /* renamed from: C */
        public final boolean f5817C;

        /* renamed from: D */
        public Animator f5818D;

        /* renamed from: t */
        public GuidedAction f5819t;

        /* renamed from: u */
        public final View f5820u;

        /* renamed from: v */
        public final TextView f5821v;

        /* renamed from: w */
        public final TextView f5822w;

        /* renamed from: x */
        public final View f5823x;

        /* renamed from: y */
        public final ImageView f5824y;

        /* renamed from: z */
        public final ImageView f5825z;

        public ViewHolder(@NonNull View view) {
            this(view, false);
        }

        @Nullable
        public GuidedAction getAction() {
            return this.f5819t;
        }

        @Nullable
        public ImageView getCheckmarkView() {
            return this.f5825z;
        }

        @Nullable
        public ImageView getChevronView() {
            return this.f5815A;
        }

        @Nullable
        public View getContentView() {
            return this.f5820u;
        }

        @Nullable
        public TextView getDescriptionView() {
            return this.f5822w;
        }

        @Nullable
        public EditText getEditableDescriptionView() {
            TextView textView = this.f5822w;
            if (textView instanceof EditText) {
                return (EditText) textView;
            }
            return null;
        }

        @Nullable
        public EditText getEditableTitleView() {
            TextView textView = this.f5821v;
            if (textView instanceof EditText) {
                return (EditText) textView;
            }
            return null;
        }

        @Nullable
        public View getEditingView() {
            int i = this.f5816B;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return this.f5823x;
                }
                return this.f5822w;
            }
            return this.f5821v;
        }

        @Override // androidx.leanback.widget.FacetProvider
        @Nullable
        public Object getFacet(@NonNull Class<?> cls) {
            if (cls == ItemAlignmentFacet.class) {
                return GuidedActionsStylist.f5791x;
            }
            return null;
        }

        @Nullable
        public ImageView getIconView() {
            return this.f5824y;
        }

        @Nullable
        public TextView getTitleView() {
            return this.f5821v;
        }

        public boolean isInEditing() {
            if (this.f5816B != 0) {
                return true;
            }
            return false;
        }

        public boolean isInEditingActivatorView() {
            if (this.f5816B == 3) {
                return true;
            }
            return false;
        }

        public boolean isInEditingDescription() {
            if (this.f5816B == 2) {
                return true;
            }
            return false;
        }

        public boolean isInEditingText() {
            int i = this.f5816B;
            if (i == 1 || i == 2) {
                return true;
            }
            return false;
        }

        public boolean isInEditingTitle() {
            if (this.f5816B == 1) {
                return true;
            }
            return false;
        }

        public boolean isSubAction() {
            return this.f5817C;
        }

        /* renamed from: o */
        public final void m1445o(boolean z) {
            int i;
            Animator animator = this.f5818D;
            if (animator != null) {
                animator.cancel();
                this.f5818D = null;
            }
            if (z) {
                i = androidx.leanback.R.attr.guidedActionPressedAnimation;
            } else {
                i = androidx.leanback.R.attr.guidedActionUnpressedAnimation;
            }
            Context context = this.itemView.getContext();
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(i, typedValue, true)) {
                Animator loadAnimator = AnimatorInflater.loadAnimator(context, typedValue.resourceId);
                this.f5818D = loadAnimator;
                loadAnimator.setTarget(this.itemView);
                this.f5818D.addListener(new C0330e1(this));
                this.f5818D.start();
            }
        }

        public ViewHolder(@NonNull View view, boolean z) {
            super(view);
            this.f5816B = 0;
            C0326d1 c0326d1 = new C0326d1(this);
            this.f5820u = view.findViewById(androidx.leanback.R.id.guidedactions_item_content);
            this.f5821v = (TextView) view.findViewById(androidx.leanback.R.id.guidedactions_item_title);
            this.f5823x = view.findViewById(androidx.leanback.R.id.guidedactions_activator_item);
            this.f5822w = (TextView) view.findViewById(androidx.leanback.R.id.guidedactions_item_description);
            this.f5824y = (ImageView) view.findViewById(androidx.leanback.R.id.guidedactions_item_icon);
            this.f5825z = (ImageView) view.findViewById(androidx.leanback.R.id.guidedactions_item_checkmark);
            this.f5815A = (ImageView) view.findViewById(androidx.leanback.R.id.guidedactions_item_chevron);
            this.f5817C = z;
            view.setAccessibilityDelegate(c0326d1);
        }
    }

    static {
        ItemAlignmentFacet itemAlignmentFacet = new ItemAlignmentFacet();
        f5791x = itemAlignmentFacet;
        ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef = new ItemAlignmentFacet.ItemAlignmentDef();
        itemAlignmentDef.setItemAlignmentViewId(androidx.leanback.R.id.guidedactions_item_title);
        itemAlignmentDef.setAlignedToTextViewBaseline(true);
        itemAlignmentDef.setItemAlignmentOffset(0);
        itemAlignmentDef.setItemAlignmentOffsetWithPadding(true);
        itemAlignmentDef.setItemAlignmentOffsetPercent(RecyclerView.f7068F0);
        itemAlignmentFacet.setAlignmentDefs(new ItemAlignmentFacet.ItemAlignmentDef[]{itemAlignmentDef});
    }

    /* renamed from: a */
    public final void m1440a(ViewHolder viewHolder, boolean z, boolean z2) {
        GuidedActionAdapter.EditListener editListener;
        if (z) {
            m1443d(viewHolder, z2);
            viewHolder.itemView.setFocusable(false);
            View view = viewHolder.f5823x;
            view.requestFocus();
            view.setOnClickListener(new ViewOnClickListenerC0408y0(this, viewHolder));
            return;
        }
        if (onUpdateActivatorView(viewHolder, viewHolder.getAction()) && (editListener = this.f5809r) != null) {
            editListener.onGuidedActionEditedAndProceed(viewHolder.getAction());
        }
        viewHolder.itemView.setFocusable(true);
        viewHolder.itemView.requestFocus();
        m1443d(null, z2);
        View view2 = viewHolder.f5823x;
        view2.setOnClickListener(null);
        view2.setClickable(false);
    }

    /* renamed from: b */
    public final void m1441b(GuidedAction guidedAction, boolean z) {
        VerticalGridView verticalGridView = this.f5794c;
        if (verticalGridView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) verticalGridView.getLayoutParams();
            GuidedActionAdapter guidedActionAdapter = (GuidedActionAdapter) this.f5794c.getAdapter();
            if (z) {
                marginLayoutParams.topMargin = -2;
                marginLayoutParams.height = -1;
                this.f5794c.setLayoutParams(marginLayoutParams);
                this.f5794c.setVisibility(0);
                this.f5795d.setVisibility(0);
                this.f5794c.requestFocus();
                guidedActionAdapter.setActions(guidedAction.getSubActions());
                return;
            }
            marginLayoutParams.topMargin = this.f5793b.getLayoutManager().findViewByPosition(((GuidedActionAdapter) this.f5793b.getAdapter()).indexOf(guidedAction)).getBottom();
            marginLayoutParams.height = 0;
            this.f5794c.setVisibility(4);
            this.f5795d.setVisibility(4);
            this.f5794c.setLayoutParams(marginLayoutParams);
            guidedActionAdapter.setActions(Collections.emptyList());
            this.f5793b.requestFocus();
        }
    }

    /* renamed from: c */
    public final void m1442c(ViewHolder viewHolder, boolean z, boolean z2) {
        if (z != viewHolder.isInEditing() && !isInExpandTransition()) {
            onEditingModeChange(viewHolder, z, z2);
        }
    }

    public void collapseAction(boolean z) {
        boolean z2;
        if (!isInExpandTransition() && this.f5810s != null) {
            if (isExpandTransitionSupported() && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            int indexOf = ((GuidedActionAdapter) getActionsGridView().getAdapter()).indexOf(this.f5810s);
            if (indexOf < 0) {
                return;
            }
            if (this.f5810s.hasEditableActivatorView()) {
                m1442c((ViewHolder) getActionsGridView().findViewHolderForPosition(indexOf), false, z2);
            } else {
                m1443d(null, z2);
            }
        }
    }

    /* renamed from: d */
    public final void m1443d(ViewHolder viewHolder, boolean z) {
        ViewHolder viewHolder2;
        boolean z2;
        float height;
        int childCount = this.f5793b.getChildCount();
        int i = 0;
        while (true) {
            if (i < childCount) {
                VerticalGridView verticalGridView = this.f5793b;
                viewHolder2 = (ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i));
                if ((viewHolder == null && viewHolder2.itemView.getVisibility() == 0) || (viewHolder != null && viewHolder2.getAction() == viewHolder.getAction())) {
                    break;
                } else {
                    i++;
                }
            } else {
                viewHolder2 = null;
                break;
            }
        }
        if (viewHolder2 == null) {
            return;
        }
        if (viewHolder != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean hasSubActions = viewHolder2.getAction().hasSubActions();
        if (z) {
            Object createTransitionSet = TransitionHelper.createTransitionSet(false);
            if (hasSubActions) {
                height = viewHolder2.itemView.getHeight();
            } else {
                height = viewHolder2.itemView.getHeight() * 0.5f;
            }
            Object createFadeAndShortSlide = TransitionHelper.createFadeAndShortSlide(112, height);
            TransitionHelper.setEpicenterCallback(createFadeAndShortSlide, new C0318b1(this));
            Object createChangeTransform = TransitionHelper.createChangeTransform();
            Object createChangeBounds = TransitionHelper.createChangeBounds(false);
            Object createFadeTransition = TransitionHelper.createFadeTransition(3);
            Object createChangeBounds2 = TransitionHelper.createChangeBounds(false);
            if (viewHolder == null) {
                TransitionHelper.setStartDelay(createFadeAndShortSlide, 150L);
                TransitionHelper.setStartDelay(createChangeTransform, 100L);
                TransitionHelper.setStartDelay(createChangeBounds, 100L);
                TransitionHelper.setStartDelay(createChangeBounds2, 100L);
            } else {
                TransitionHelper.setStartDelay(createFadeTransition, 100L);
                TransitionHelper.setStartDelay(createChangeBounds2, 50L);
                TransitionHelper.setStartDelay(createChangeTransform, 50L);
                TransitionHelper.setStartDelay(createChangeBounds, 50L);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                VerticalGridView verticalGridView2 = this.f5793b;
                ViewHolder viewHolder3 = (ViewHolder) verticalGridView2.getChildViewHolder(verticalGridView2.getChildAt(i2));
                if (viewHolder3 == viewHolder2) {
                    if (hasSubActions) {
                        TransitionHelper.include(createChangeTransform, viewHolder3.itemView);
                        TransitionHelper.include(createChangeBounds, viewHolder3.itemView);
                    }
                } else {
                    TransitionHelper.include(createFadeAndShortSlide, viewHolder3.itemView);
                    TransitionHelper.exclude(createFadeTransition, viewHolder3.itemView, true);
                }
            }
            TransitionHelper.include(createChangeBounds2, this.f5794c);
            TransitionHelper.include(createChangeBounds2, this.f5795d);
            TransitionHelper.addTransition(createTransitionSet, createFadeAndShortSlide);
            if (hasSubActions) {
                TransitionHelper.addTransition(createTransitionSet, createChangeTransform);
                TransitionHelper.addTransition(createTransitionSet, createChangeBounds);
            }
            TransitionHelper.addTransition(createTransitionSet, createFadeTransition);
            TransitionHelper.addTransition(createTransitionSet, createChangeBounds2);
            this.f5811t = createTransitionSet;
            TransitionHelper.addTransitionListener(createTransitionSet, new C0322c1(this));
            if (z2 && hasSubActions) {
                int bottom = viewHolder.itemView.getBottom();
                VerticalGridView verticalGridView3 = this.f5794c;
                verticalGridView3.offsetTopAndBottom(bottom - verticalGridView3.getTop());
                View view = this.f5795d;
                view.offsetTopAndBottom(bottom - view.getTop());
            }
            TransitionHelper.beginDelayedTransition(this.f5792a, this.f5811t);
        }
        onUpdateExpandedViewHolder(viewHolder);
        if (hasSubActions) {
            m1441b(viewHolder2.getAction(), z2);
        }
    }

    /* renamed from: e */
    public final void m1444e(ViewHolder viewHolder) {
        if (!viewHolder.isSubAction()) {
            GuidedAction guidedAction = this.f5810s;
            View view = viewHolder.f5823x;
            if (guidedAction == null) {
                viewHolder.itemView.setVisibility(0);
                viewHolder.itemView.setTranslationY(RecyclerView.f7068F0);
                if (view != null) {
                    viewHolder.f5823x.setActivated(false);
                    View view2 = viewHolder.itemView;
                    if (view2 instanceof GuidedActionItemContainer) {
                        ((GuidedActionItemContainer) view2).f5787a = true;
                    }
                }
            } else if (viewHolder.getAction() == this.f5810s) {
                viewHolder.itemView.setVisibility(0);
                if (viewHolder.getAction().hasSubActions()) {
                    viewHolder.itemView.setTranslationY(((int) ((this.f5814w * this.f5793b.getHeight()) / 100.0f)) - viewHolder.itemView.getBottom());
                } else if (view != null) {
                    viewHolder.itemView.setTranslationY(RecyclerView.f7068F0);
                    viewHolder.f5823x.setActivated(true);
                    View view3 = viewHolder.itemView;
                    if (view3 instanceof GuidedActionItemContainer) {
                        ((GuidedActionItemContainer) view3).f5787a = false;
                    }
                }
            } else {
                viewHolder.itemView.setVisibility(4);
                viewHolder.itemView.setTranslationY(RecyclerView.f7068F0);
            }
        }
        if (viewHolder.f5815A != null) {
            onBindChevronView(viewHolder, viewHolder.getAction());
        }
    }

    public void expandAction(@NonNull GuidedAction guidedAction, boolean z) {
        int indexOf;
        if (isInExpandTransition() || this.f5810s != null || (indexOf = ((GuidedActionAdapter) getActionsGridView().getAdapter()).indexOf(guidedAction)) < 0) {
            return;
        }
        if (isExpandTransitionSupported() && z) {
            getActionsGridView().setSelectedPosition(indexOf, new C0313a1(this));
            return;
        }
        getActionsGridView().setSelectedPosition(indexOf, new C0412z0(this));
        if (guidedAction.hasSubActions()) {
            m1441b(guidedAction, true);
        }
    }

    @Nullable
    public VerticalGridView getActionsGridView() {
        return this.f5793b;
    }

    @Nullable
    public GuidedAction getExpandedAction() {
        return this.f5810s;
    }

    public int getItemViewType(@NonNull GuidedAction guidedAction) {
        if (guidedAction instanceof GuidedDatePickerAction) {
            return 1;
        }
        return 0;
    }

    @Nullable
    public VerticalGridView getSubActionsGridView() {
        return this.f5794c;
    }

    public final boolean isBackKeyToCollapseActivatorView() {
        return this.f5813v;
    }

    public final boolean isBackKeyToCollapseSubActions() {
        return this.f5812u;
    }

    public boolean isButtonActions() {
        return this.f5797f;
    }

    public boolean isExpandTransitionSupported() {
        return true;
    }

    public boolean isExpanded() {
        if (this.f5810s != null) {
            return true;
        }
        return false;
    }

    public boolean isInExpandTransition() {
        if (this.f5811t != null) {
            return true;
        }
        return false;
    }

    public boolean isSubActionsExpanded() {
        GuidedAction guidedAction = this.f5810s;
        if (guidedAction != null && guidedAction.hasSubActions()) {
            return true;
        }
        return false;
    }

    public void onAnimateItemChecked(@NonNull ViewHolder viewHolder, boolean z) {
        KeyEvent.Callback callback = viewHolder.f5825z;
        if (callback instanceof Checkable) {
            ((Checkable) callback).setChecked(z);
        }
    }

    public void onAnimateItemFocused(@NonNull ViewHolder viewHolder, boolean z) {
    }

    public void onAnimateItemPressed(@NonNull ViewHolder viewHolder, boolean z) {
        viewHolder.m1445o(z);
    }

    public void onAnimateItemPressedCancelled(@NonNull ViewHolder viewHolder) {
        viewHolder.m1445o(false);
    }

    public void onBindActivatorView(@NonNull ViewHolder viewHolder, @NonNull GuidedAction guidedAction) {
        if (guidedAction instanceof GuidedDatePickerAction) {
            GuidedDatePickerAction guidedDatePickerAction = (GuidedDatePickerAction) guidedAction;
            DatePicker datePicker = (DatePicker) viewHolder.f5823x;
            datePicker.setDatePickerFormat(guidedDatePickerAction.getDatePickerFormat());
            if (guidedDatePickerAction.getMinDate() != Long.MIN_VALUE) {
                datePicker.setMinDate(guidedDatePickerAction.getMinDate());
            }
            if (guidedDatePickerAction.getMaxDate() != Long.MAX_VALUE) {
                datePicker.setMaxDate(guidedDatePickerAction.getMaxDate());
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(guidedDatePickerAction.getDate());
            datePicker.setDate(calendar.get(1), calendar.get(2), calendar.get(5), false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBindCheckMarkView(@NonNull ViewHolder viewHolder, @NonNull GuidedAction guidedAction) {
        int i;
        Drawable drawable;
        if (guidedAction.getCheckSetId() != 0) {
            viewHolder.f5825z.setVisibility(0);
            if (guidedAction.getCheckSetId() == -1) {
                i = android.R.attr.listChoiceIndicatorMultiple;
            } else {
                i = android.R.attr.listChoiceIndicatorSingle;
            }
            ImageView imageView = viewHolder.f5825z;
            Context context = imageView.getContext();
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(i, typedValue, true)) {
                drawable = ContextCompat.getDrawable(context, typedValue.resourceId);
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof Checkable) {
                ((Checkable) imageView).setChecked(guidedAction.isChecked());
                return;
            }
            return;
        }
        viewHolder.f5825z.setVisibility(8);
    }

    public void onBindChevronView(@NonNull ViewHolder viewHolder, @NonNull GuidedAction guidedAction) {
        float f;
        float f2;
        boolean hasNext = guidedAction.hasNext();
        boolean hasSubActions = guidedAction.hasSubActions();
        if (!hasNext && !hasSubActions) {
            viewHolder.f5815A.setVisibility(8);
            return;
        }
        viewHolder.f5815A.setVisibility(0);
        if (guidedAction.isEnabled()) {
            f = this.f5802k;
        } else {
            f = this.f5803l;
        }
        ImageView imageView = viewHolder.f5815A;
        imageView.setAlpha(f);
        if (hasNext) {
            ViewGroup viewGroup = this.f5792a;
            if (viewGroup != null && viewGroup.getLayoutDirection() == 1) {
                f2 = 180.0f;
            } else {
                f2 = RecyclerView.f7068F0;
            }
            imageView.setRotation(f2);
            return;
        }
        if (guidedAction == this.f5810s) {
            imageView.setRotation(270.0f);
        } else {
            imageView.setRotation(90.0f);
        }
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @NonNull GuidedAction guidedAction) {
        int i;
        float f;
        float f2;
        viewHolder.f5819t = guidedAction;
        TextView textView = viewHolder.f5821v;
        if (textView != null) {
            textView.setInputType(guidedAction.getInputType());
            textView.setText(guidedAction.getTitle());
            if (guidedAction.isEnabled()) {
                f2 = this.f5798g;
            } else {
                f2 = this.f5799h;
            }
            textView.setAlpha(f2);
            textView.setFocusable(false);
            textView.setClickable(false);
            textView.setLongClickable(false);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                if (guidedAction.isEditable()) {
                    hy0.m5139a(textView, guidedAction.getAutofillHints());
                } else {
                    hy0.m5139a(textView, null);
                }
            } else if (i2 >= 26) {
                hy0.m5140b(textView, 2);
            }
        }
        TextView textView2 = viewHolder.f5822w;
        if (textView2 != null) {
            textView2.setInputType(guidedAction.getDescriptionInputType());
            textView2.setText(guidedAction.getDescription());
            if (TextUtils.isEmpty(guidedAction.getDescription())) {
                i = 8;
            } else {
                i = 0;
            }
            textView2.setVisibility(i);
            if (guidedAction.isEnabled()) {
                f = this.f5800i;
            } else {
                f = this.f5801j;
            }
            textView2.setAlpha(f);
            textView2.setFocusable(false);
            textView2.setClickable(false);
            textView2.setLongClickable(false);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28) {
                if (guidedAction.isDescriptionEditable()) {
                    hy0.m5139a(textView2, guidedAction.getAutofillHints());
                } else {
                    hy0.m5139a(textView2, null);
                }
            } else if (i3 >= 26) {
                hy0.m5140b(textView, 2);
            }
        }
        if (viewHolder.f5825z != null) {
            onBindCheckMarkView(viewHolder, guidedAction);
        }
        ImageView imageView = viewHolder.f5824y;
        if (imageView != null) {
            Drawable icon = guidedAction.getIcon();
            if (icon != null) {
                imageView.setImageLevel(icon.getLevel());
                imageView.setImageDrawable(icon);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        if (guidedAction.hasMultilineDescription()) {
            if (textView != null) {
                int i4 = this.f5805n;
                if (i4 == 1) {
                    textView.setSingleLine(true);
                } else {
                    textView.setSingleLine(false);
                    textView.setMaxLines(i4);
                }
                textView.setInputType(textView.getInputType() | 131072);
                if (textView2 != null) {
                    textView2.setInputType(textView2.getInputType() | 131072);
                    textView2.setMaxHeight((this.f5808q - (this.f5807p * 2)) - (textView.getLineHeight() * (this.f5805n * 2)));
                }
            }
        } else {
            if (textView != null) {
                int i5 = this.f5804m;
                if (i5 == 1) {
                    textView.setSingleLine(true);
                } else {
                    textView.setSingleLine(false);
                    textView.setMaxLines(i5);
                }
            }
            if (textView2 != null) {
                int i6 = this.f5806o;
                if (i6 == 1) {
                    textView2.setSingleLine(true);
                } else {
                    textView2.setSingleLine(false);
                    textView2.setMaxLines(i6);
                }
            }
        }
        if (viewHolder.f5823x != null) {
            onBindActivatorView(viewHolder, guidedAction);
        }
        m1442c(viewHolder, false, false);
        if (guidedAction.isFocusable()) {
            viewHolder.itemView.setFocusable(true);
            ((ViewGroup) viewHolder.itemView).setDescendantFocusability(131072);
        } else {
            viewHolder.itemView.setFocusable(false);
            ((ViewGroup) viewHolder.itemView).setDescendantFocusability(393216);
        }
        setupImeOptions(viewHolder, guidedAction);
        m1444e(viewHolder);
    }

    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        int i;
        int i2;
        float f = layoutInflater.getContext().getTheme().obtainStyledAttributes(androidx.leanback.R.styleable.LeanbackGuidedStepTheme).getFloat(androidx.leanback.R.styleable.LeanbackGuidedStepTheme_guidedStepKeyline, 40.0f);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(onProvideLayoutId(), viewGroup, false);
        this.f5792a = viewGroup2;
        if (this.f5797f) {
            i = androidx.leanback.R.id.guidedactions_content2;
        } else {
            i = androidx.leanback.R.id.guidedactions_content;
        }
        this.f5796e = viewGroup2.findViewById(i);
        ViewGroup viewGroup3 = this.f5792a;
        if (viewGroup3 instanceof VerticalGridView) {
            this.f5793b = (VerticalGridView) viewGroup3;
        } else {
            if (this.f5797f) {
                i2 = androidx.leanback.R.id.guidedactions_list2;
            } else {
                i2 = androidx.leanback.R.id.guidedactions_list;
            }
            VerticalGridView verticalGridView = (VerticalGridView) viewGroup3.findViewById(i2);
            this.f5793b = verticalGridView;
            if (verticalGridView != null) {
                verticalGridView.setWindowAlignmentOffsetPercent(f);
                this.f5793b.setWindowAlignment(0);
                if (!this.f5797f) {
                    this.f5794c = (VerticalGridView) this.f5792a.findViewById(androidx.leanback.R.id.guidedactions_sub_list);
                    this.f5795d = this.f5792a.findViewById(androidx.leanback.R.id.guidedactions_sub_list_background);
                }
            } else {
                throw new IllegalStateException("No ListView exists.");
            }
        }
        this.f5793b.setFocusable(false);
        this.f5793b.setFocusableInTouchMode(false);
        Context context = this.f5792a.getContext();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.leanback.R.attr.guidedActionEnabledChevronAlpha, typedValue, true);
        this.f5802k = typedValue.getFloat();
        context.getTheme().resolveAttribute(androidx.leanback.R.attr.guidedActionDisabledChevronAlpha, typedValue, true);
        this.f5803l = typedValue.getFloat();
        context.getTheme().resolveAttribute(androidx.leanback.R.attr.guidedActionTitleMinLines, typedValue, true);
        this.f5804m = context.getResources().getInteger(typedValue.resourceId);
        context.getTheme().resolveAttribute(androidx.leanback.R.attr.guidedActionTitleMaxLines, typedValue, true);
        this.f5805n = context.getResources().getInteger(typedValue.resourceId);
        context.getTheme().resolveAttribute(androidx.leanback.R.attr.guidedActionDescriptionMinLines, typedValue, true);
        this.f5806o = context.getResources().getInteger(typedValue.resourceId);
        context.getTheme().resolveAttribute(androidx.leanback.R.attr.guidedActionVerticalPadding, typedValue, true);
        this.f5807p = context.getResources().getDimensionPixelSize(typedValue.resourceId);
        this.f5808q = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
        context.getResources().getValue(androidx.leanback.R.dimen.lb_guidedactions_item_unselected_text_alpha, typedValue, true);
        this.f5798g = typedValue.getFloat();
        context.getResources().getValue(androidx.leanback.R.dimen.lb_guidedactions_item_disabled_text_alpha, typedValue, true);
        this.f5799h = typedValue.getFloat();
        context.getResources().getValue(androidx.leanback.R.dimen.lb_guidedactions_item_unselected_description_text_alpha, typedValue, true);
        this.f5800i = typedValue.getFloat();
        context.getResources().getValue(androidx.leanback.R.dimen.lb_guidedactions_item_disabled_description_text_alpha, typedValue, true);
        this.f5801j = typedValue.getFloat();
        this.f5814w = GuidanceStylingRelativeLayout.m1435a(context);
        View view = this.f5796e;
        if (view instanceof GuidedActionsRelativeLayout) {
            ((GuidedActionsRelativeLayout) view).f5790c = new b01(19, this);
        }
        return this.f5792a;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(onProvideItemLayoutId(), viewGroup, false), viewGroup == this.f5794c);
    }

    public void onDestroyView() {
        this.f5810s = null;
        this.f5811t = null;
        this.f5793b = null;
        this.f5794c = null;
        this.f5795d = null;
        this.f5796e = null;
        this.f5792a = null;
    }

    @Deprecated
    public void onEditingModeChange(ViewHolder viewHolder, GuidedAction guidedAction, boolean z) {
    }

    @Override // androidx.leanback.widget.FragmentAnimationProvider
    public void onImeAppearing(@NonNull List<Animator> list) {
    }

    @Override // androidx.leanback.widget.FragmentAnimationProvider
    public void onImeDisappearing(@NonNull List<Animator> list) {
    }

    public int onProvideItemLayoutId() {
        return androidx.leanback.R.layout.lb_guidedactions_item;
    }

    public int onProvideLayoutId() {
        if (this.f5797f) {
            return androidx.leanback.R.layout.lb_guidedbuttonactions;
        }
        return androidx.leanback.R.layout.lb_guidedactions;
    }

    public boolean onUpdateActivatorView(@NonNull ViewHolder viewHolder, @NonNull GuidedAction guidedAction) {
        if (guidedAction instanceof GuidedDatePickerAction) {
            GuidedDatePickerAction guidedDatePickerAction = (GuidedDatePickerAction) guidedAction;
            DatePicker datePicker = (DatePicker) viewHolder.f5823x;
            if (guidedDatePickerAction.getDate() != datePicker.getDate()) {
                guidedDatePickerAction.setDate(datePicker.getDate());
                return true;
            }
            return false;
        }
        return false;
    }

    public void onUpdateExpandedViewHolder(@Nullable ViewHolder viewHolder) {
        if (viewHolder == null) {
            this.f5810s = null;
            this.f5793b.setPruneChild(true);
        } else if (viewHolder.getAction() != this.f5810s) {
            this.f5810s = viewHolder.getAction();
            this.f5793b.setPruneChild(false);
        }
        this.f5793b.setAnimateChildLayout(false);
        int childCount = this.f5793b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            VerticalGridView verticalGridView = this.f5793b;
            m1444e((ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i)));
        }
    }

    public void openInEditMode(@NonNull GuidedAction guidedAction) {
        GuidedActionAdapter guidedActionAdapter = (GuidedActionAdapter) getActionsGridView().getAdapter();
        int indexOf = guidedActionAdapter.getActions().indexOf(guidedAction);
        if (indexOf >= 0 && guidedAction.isEditable()) {
            getActionsGridView().setSelectedPosition(indexOf, new C0404x0(guidedActionAdapter));
        }
    }

    public void setAsButtonActions() {
        if (this.f5792a == null) {
            this.f5797f = true;
            return;
        }
        throw new IllegalStateException("setAsButtonActions() must be called before creating views");
    }

    public final void setBackKeyToCollapseActivatorView(boolean z) {
        this.f5813v = z;
    }

    public final void setBackKeyToCollapseSubActions(boolean z) {
        this.f5812u = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setEditListener(@NonNull GuidedActionAdapter.EditListener editListener) {
        this.f5809r = editListener;
    }

    @Deprecated
    public void setEditingMode(ViewHolder viewHolder, GuidedAction guidedAction, boolean z) {
        if (z != viewHolder.isInEditing() && isInExpandTransition()) {
            onEditingModeChange(viewHolder, guidedAction, z);
        }
    }

    @Deprecated
    public void setExpandedViewHolder(ViewHolder viewHolder) {
        GuidedAction action;
        if (viewHolder == null) {
            action = null;
        } else {
            action = viewHolder.getAction();
        }
        expandAction(action, isExpandTransitionSupported());
    }

    public void setupImeOptions(@NonNull ViewHolder viewHolder, @NonNull GuidedAction guidedAction) {
        EditText editableTitleView = viewHolder.getEditableTitleView();
        if (editableTitleView != null) {
            editableTitleView.setImeOptions(5);
        }
        EditText editableDescriptionView = viewHolder.getEditableDescriptionView();
        if (editableDescriptionView != null) {
            editableDescriptionView.setImeOptions(5);
        }
    }

    @Deprecated
    public void startExpandedTransition(ViewHolder viewHolder) {
        GuidedAction action;
        if (viewHolder == null) {
            action = null;
        } else {
            action = viewHolder.getAction();
        }
        expandAction(action, isExpandTransitionSupported());
    }

    @CallSuper
    public void onEditingModeChange(@NonNull ViewHolder viewHolder, boolean z, boolean z2) {
        GuidedAction action = viewHolder.getAction();
        TextView titleView = viewHolder.getTitleView();
        TextView descriptionView = viewHolder.getDescriptionView();
        View view = viewHolder.f5823x;
        if (z) {
            CharSequence editTitle = action.getEditTitle();
            if (titleView != null && editTitle != null) {
                titleView.setText(editTitle);
            }
            CharSequence editDescription = action.getEditDescription();
            if (descriptionView != null && editDescription != null) {
                descriptionView.setText(editDescription);
            }
            if (action.isDescriptionEditable()) {
                if (descriptionView != null) {
                    descriptionView.setVisibility(0);
                    descriptionView.setInputType(action.getDescriptionEditInputType());
                    descriptionView.requestFocusFromTouch();
                }
                viewHolder.f5816B = 2;
            } else if (action.isEditable()) {
                if (titleView != null) {
                    titleView.setInputType(action.getEditInputType());
                    titleView.requestFocusFromTouch();
                }
                viewHolder.f5816B = 1;
            } else if (view != null) {
                m1440a(viewHolder, z, z2);
                viewHolder.f5816B = 3;
            }
        } else {
            if (titleView != null) {
                titleView.setText(action.getTitle());
            }
            if (descriptionView != null) {
                descriptionView.setText(action.getDescription());
            }
            int i = viewHolder.f5816B;
            if (i == 2) {
                if (descriptionView != null) {
                    descriptionView.setVisibility(TextUtils.isEmpty(action.getDescription()) ? 8 : 0);
                    descriptionView.setInputType(action.getDescriptionInputType());
                }
            } else if (i == 1) {
                if (titleView != null) {
                    titleView.setInputType(action.getInputType());
                }
            } else if (i == 3 && view != null) {
                m1440a(viewHolder, z, z2);
            }
            viewHolder.f5816B = 0;
        }
        onEditingModeChange(viewHolder, action, z);
    }

    public int onProvideItemLayoutId(int i) {
        if (i == 0) {
            return onProvideItemLayoutId();
        }
        if (i == 1) {
            return androidx.leanback.R.layout.lb_guidedactions_datepicker_item;
        }
        throw new RuntimeException(ye0.m8292l(i, "ViewType ", " not supported in GuidedActionsStylist"));
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return onCreateViewHolder(viewGroup);
        }
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(onProvideItemLayoutId(i), viewGroup, false), viewGroup == this.f5794c);
    }
}
