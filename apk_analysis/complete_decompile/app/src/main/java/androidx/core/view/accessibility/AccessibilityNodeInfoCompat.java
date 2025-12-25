package androidx.core.view.accessibility;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p000.AbstractC1497l3;
import p000.AbstractC1534m3;
import p000.AbstractC1608o3;
import p000.AbstractC1673p3;
import p000.AbstractC1710q3;
import p000.AbstractC1747r3;
import p000.AbstractC1784s3;
import p000.AbstractC1821t3;

/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_DIRECTION_INT = "androidx.core.view.accessibility.action.ARGUMENT_DIRECTION_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";

    @SuppressLint({"ActionValue"})
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SCROLL_AMOUNT_FLOAT = "androidx.core.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    public static final int EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH = 20000;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    public static final int FLAG_PREFETCH_ANCESTORS = 1;
    public static final int FLAG_PREFETCH_DESCENDANTS_BREADTH_FIRST = 16;
    public static final int FLAG_PREFETCH_DESCENDANTS_DEPTH_FIRST = 8;
    public static final int FLAG_PREFETCH_DESCENDANTS_HYBRID = 4;
    public static final int FLAG_PREFETCH_SIBLINGS = 2;
    public static final int FLAG_PREFETCH_UNINTERRUPTIBLE = 32;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;

    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_NUMBER_OF_PREFETCHED_NODES = 50;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;

    /* renamed from: c */
    public static int f3947c;

    /* renamed from: a */
    public final AccessibilityNodeInfo f3948a;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mParentVirtualDescendantId = -1;

    /* renamed from: b */
    public int f3949b = -1;

    /* loaded from: classes.dex */
    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_CANCEL;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_DROP;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_START;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP;

        @NonNull
        public static final AccessibilityActionCompat ACTION_IME_ENTER;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_UP;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PRESS_AND_HOLD;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;

        @NonNull
        @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
        public static final AccessibilityActionCompat ACTION_SCROLL_IN_DIRECTION;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;

        @NonNull
        public static final AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP;

        /* renamed from: a */
        public final Object f3950a;

        /* renamed from: b */
        public final int f3951b;

        /* renamed from: c */
        public final Class f3952c;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected final AccessibilityViewCommand mCommand;
        public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SELECT = new AccessibilityActionCompat(4, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLICK = new AccessibilityActionCompat(16, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = new AccessibilityActionCompat(32, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_COPY = new AccessibilityActionCompat(16384, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_PASTE = new AccessibilityActionCompat(32768, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CUT = new AccessibilityActionCompat(65536, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, AccessibilityViewCommand.SetSelectionArguments.class);
        public static final AccessibilityActionCompat ACTION_EXPAND = new AccessibilityActionCompat(262144, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(1048576, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, AccessibilityViewCommand.SetTextArguments.class);

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction20 = null;
            int i = Build.VERSION.SDK_INT;
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            if (i >= 29) {
                accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
                accessibilityAction = accessibilityAction19;
            } else {
                accessibilityAction = null;
            }
            ACTION_PAGE_UP = new AccessibilityActionCompat(accessibilityAction, R.id.accessibilityActionPageUp, null, null, null);
            if (i >= 29) {
                accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
                accessibilityAction2 = accessibilityAction18;
            } else {
                accessibilityAction2 = null;
            }
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(accessibilityAction2, R.id.accessibilityActionPageDown, null, null, null);
            if (i >= 29) {
                accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
                accessibilityAction3 = accessibilityAction17;
            } else {
                accessibilityAction3 = null;
            }
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(accessibilityAction3, R.id.accessibilityActionPageLeft, null, null, null);
            if (i >= 29) {
                accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
                accessibilityAction4 = accessibilityAction16;
            } else {
                accessibilityAction4 = null;
            }
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(accessibilityAction4, R.id.accessibilityActionPageRight, null, null, null);
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            if (i >= 24) {
                accessibilityAction5 = AbstractC1608o3.m6421i();
            } else {
                accessibilityAction5 = null;
            }
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(accessibilityAction5, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            if (i >= 26) {
                accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
                accessibilityAction6 = accessibilityAction15;
            } else {
                accessibilityAction6 = null;
            }
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(accessibilityAction6, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            if (i >= 28) {
                accessibilityAction7 = AbstractC1534m3.m6031m();
            } else {
                accessibilityAction7 = null;
            }
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(accessibilityAction7, R.id.accessibilityActionShowTooltip, null, null, null);
            if (i >= 28) {
                accessibilityAction8 = AbstractC1534m3.m6042x();
            } else {
                accessibilityAction8 = null;
            }
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(accessibilityAction8, R.id.accessibilityActionHideTooltip, null, null, null);
            if (i >= 30) {
                accessibilityAction9 = AbstractC1673p3.m6808e();
            } else {
                accessibilityAction9 = null;
            }
            ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(accessibilityAction9, R.id.accessibilityActionPressAndHold, null, null, null);
            if (i >= 30) {
                accessibilityAction10 = AbstractC1673p3.m6801B();
            } else {
                accessibilityAction10 = null;
            }
            ACTION_IME_ENTER = new AccessibilityActionCompat(accessibilityAction10, R.id.accessibilityActionImeEnter, null, null, null);
            if (i >= 32) {
                accessibilityAction11 = AbstractC1710q3.m6987c();
            } else {
                accessibilityAction11 = null;
            }
            ACTION_DRAG_START = new AccessibilityActionCompat(accessibilityAction11, R.id.ALT, null, null, null);
            if (i >= 32) {
                accessibilityAction12 = AbstractC1710q3.m6993i();
            } else {
                accessibilityAction12 = null;
            }
            ACTION_DRAG_DROP = new AccessibilityActionCompat(accessibilityAction12, R.id.CTRL, null, null, null);
            if (i >= 32) {
                accessibilityAction13 = AbstractC1710q3.m6995k();
            } else {
                accessibilityAction13 = null;
            }
            ACTION_DRAG_CANCEL = new AccessibilityActionCompat(accessibilityAction13, R.id.FUNCTION, null, null, null);
            if (i >= 33) {
                accessibilityAction14 = AbstractC1747r3.m7173d();
            } else {
                accessibilityAction14 = null;
            }
            ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityActionCompat(accessibilityAction14, R.id.KEYCODE_0, null, null, null);
            if (i >= 34) {
                accessibilityAction20 = AbstractC1821t3.m7437a();
            }
            ACTION_SCROLL_IN_DIRECTION = new AccessibilityActionCompat(accessibilityAction20, R.id.KEYCODE_3D_MODE, null, null, null);
        }

        public AccessibilityActionCompat(int i, CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat(null, this.f3951b, charSequence, accessibilityViewCommand, this.f3952c);
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            Object obj2 = ((AccessibilityActionCompat) obj).f3950a;
            Object obj3 = this.f3950a;
            if (obj3 == null) {
                if (obj2 != null) {
                    return false;
                }
                return true;
            }
            if (!obj3.equals(obj2)) {
                return false;
            }
            return true;
        }

        public int getId() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f3950a).getId();
        }

        public CharSequence getLabel() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f3950a).getLabel();
        }

        public int hashCode() {
            Object obj = this.f3950a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean perform(View view, Bundle bundle) {
            String name;
            AccessibilityViewCommand.CommandArguments commandArguments;
            if (this.mCommand != null) {
                Class cls = this.f3952c;
                AccessibilityViewCommand.CommandArguments commandArguments2 = null;
                if (cls != null) {
                    try {
                        commandArguments = (AccessibilityViewCommand.CommandArguments) cls.getDeclaredConstructor(null).newInstance(null);
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        commandArguments.setBundle(bundle);
                        commandArguments2 = commandArguments;
                    } catch (Exception e2) {
                        e = e2;
                        commandArguments2 = commandArguments;
                        if (cls == null) {
                            name = "null";
                        } else {
                            name = cls.getName();
                        }
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(name), e);
                        return this.mCommand.perform(view, commandArguments2);
                    }
                }
                return this.mCommand.perform(view, commandArguments2);
            }
            return false;
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
            String m921b = AccessibilityNodeInfoCompat.m921b(this.f3951b);
            if (m921b.equals("ACTION_UNKNOWN") && getLabel() != null) {
                m921b = getLabel().toString();
            }
            sb.append(m921b);
            return sb.toString();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this(null, i, charSequence, accessibilityViewCommand, null);
        }

        public AccessibilityActionCompat(int i, Class cls) {
            this(null, i, null, null, cls);
        }

        public AccessibilityActionCompat(Object obj, int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class cls) {
            this.f3951b = i;
            this.mCommand = accessibilityViewCommand;
            if (obj == null) {
                this.f3950a = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.f3950a = obj;
            }
            this.f3952c = cls;
        }
    }

    /* loaded from: classes.dex */
    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;

        /* renamed from: a */
        public final AccessibilityNodeInfo.CollectionInfo f3953a;

        public CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo collectionInfo) {
            this.f3953a = collectionInfo;
        }

        public static CollectionInfoCompat obtain(int i, int i2, boolean z, int i3) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
        }

        public int getColumnCount() {
            return this.f3953a.getColumnCount();
        }

        public int getRowCount() {
            return this.f3953a.getRowCount();
        }

        public int getSelectionMode() {
            return this.f3953a.getSelectionMode();
        }

        public boolean isHierarchical() {
            return this.f3953a.isHierarchical();
        }

        public static CollectionInfoCompat obtain(int i, int i2, boolean z) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
        }
    }

    /* loaded from: classes.dex */
    public static class CollectionItemInfoCompat {

        /* renamed from: a */
        public final AccessibilityNodeInfo.CollectionItemInfo f3954a;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            public boolean f3955a;

            /* renamed from: b */
            public int f3956b;

            /* renamed from: c */
            public int f3957c;

            /* renamed from: d */
            public int f3958d;

            /* renamed from: e */
            public int f3959e;

            /* renamed from: f */
            public boolean f3960f;

            /* renamed from: g */
            public String f3961g;

            /* renamed from: h */
            public String f3962h;

            @NonNull
            public CollectionItemInfoCompat build() {
                if (Build.VERSION.SDK_INT >= 33) {
                    return AbstractC0203d.m927a(this.f3955a, this.f3956b, this.f3957c, this.f3958d, this.f3959e, this.f3960f, this.f3961g, this.f3962h);
                }
                return AbstractC0202c.m926a(this.f3957c, this.f3959e, this.f3956b, this.f3958d, this.f3955a, this.f3960f);
            }

            @NonNull
            public Builder setColumnIndex(int i) {
                this.f3956b = i;
                return this;
            }

            @NonNull
            public Builder setColumnSpan(int i) {
                this.f3958d = i;
                return this;
            }

            @NonNull
            public Builder setColumnTitle(@Nullable String str) {
                this.f3962h = str;
                return this;
            }

            @NonNull
            public Builder setHeading(boolean z) {
                this.f3955a = z;
                return this;
            }

            @NonNull
            public Builder setRowIndex(int i) {
                this.f3957c = i;
                return this;
            }

            @NonNull
            public Builder setRowSpan(int i) {
                this.f3959e = i;
                return this;
            }

            @NonNull
            public Builder setRowTitle(@Nullable String str) {
                this.f3961g = str;
                return this;
            }

            @NonNull
            public Builder setSelected(boolean z) {
                this.f3960f = z;
                return this;
            }
        }

        public CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo) {
            this.f3954a = collectionItemInfo;
        }

        public static CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
        }

        public int getColumnIndex() {
            return this.f3954a.getColumnIndex();
        }

        public int getColumnSpan() {
            return this.f3954a.getColumnSpan();
        }

        @Nullable
        public String getColumnTitle() {
            if (Build.VERSION.SDK_INT >= 33) {
                return AbstractC0203d.m929c(this.f3954a);
            }
            return null;
        }

        public int getRowIndex() {
            return this.f3954a.getRowIndex();
        }

        public int getRowSpan() {
            return this.f3954a.getRowSpan();
        }

        @Nullable
        public String getRowTitle() {
            if (Build.VERSION.SDK_INT >= 33) {
                return AbstractC0203d.m930d(this.f3954a);
            }
            return null;
        }

        @Deprecated
        public boolean isHeading() {
            return this.f3954a.isHeading();
        }

        public boolean isSelected() {
            return this.f3954a.isSelected();
        }

        public static CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
        }
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object obj) {
        this.f3948a = (AccessibilityNodeInfo) obj;
    }

    /* renamed from: b */
    public static String m921b(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case R.id.accessibilityActionMoveWindow:
                        return "ACTION_MOVE_WINDOW";
                    case R.id.KEYCODE_3D_MODE:
                        return "ACTION_SCROLL_IN_DIRECTION";
                    default:
                        switch (i) {
                            case R.id.accessibilityActionShowOnScreen:
                                return "ACTION_SHOW_ON_SCREEN";
                            case R.id.accessibilityActionScrollToPosition:
                                return "ACTION_SCROLL_TO_POSITION";
                            case R.id.accessibilityActionScrollUp:
                                return "ACTION_SCROLL_UP";
                            case R.id.accessibilityActionScrollLeft:
                                return "ACTION_SCROLL_LEFT";
                            case R.id.accessibilityActionScrollDown:
                                return "ACTION_SCROLL_DOWN";
                            case R.id.accessibilityActionScrollRight:
                                return "ACTION_SCROLL_RIGHT";
                            case R.id.accessibilityActionContextClick:
                                return "ACTION_CONTEXT_CLICK";
                            case R.id.accessibilityActionSetProgress:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i) {
                                    case R.id.accessibilityActionShowTooltip:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case R.id.accessibilityActionHideTooltip:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case R.id.accessibilityActionPageUp:
                                        return "ACTION_PAGE_UP";
                                    case R.id.accessibilityActionPageDown:
                                        return "ACTION_PAGE_DOWN";
                                    case R.id.accessibilityActionPageLeft:
                                        return "ACTION_PAGE_LEFT";
                                    case R.id.accessibilityActionPageRight:
                                        return "ACTION_PAGE_RIGHT";
                                    case R.id.accessibilityActionPressAndHold:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        switch (i) {
                                            case R.id.accessibilityActionImeEnter:
                                                return "ACTION_IME_ENTER";
                                            case R.id.ALT:
                                                return "ACTION_DRAG_START";
                                            case R.id.CTRL:
                                                return "ACTION_DRAG_DROP";
                                            case R.id.FUNCTION:
                                                return "ACTION_DRAG_CANCEL";
                                            default:
                                                return "ACTION_UNKNOWN";
                                        }
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    /* renamed from: e */
    public static AccessibilityNodeInfoCompat m922e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            return new AccessibilityNodeInfoCompat((Object) accessibilityNodeInfo);
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] getClickableSpans(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return wrap(AccessibilityNodeInfo.obtain(view));
    }

    public static AccessibilityNodeInfoCompat wrap(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    /* renamed from: a */
    public final ArrayList m923a(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        ArrayList<Integer> integerArrayList = accessibilityNodeInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            accessibilityNodeInfo.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    public void addAction(int i) {
        this.f3948a.addAction(i);
    }

    public void addChild(View view) {
        this.f3948a.addChild(view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addSpansToExtras(CharSequence charSequence, View view) {
        int i;
        if (Build.VERSION.SDK_INT < 26) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SparseArray sparseArray = (SparseArray) view.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    if (((WeakReference) sparseArray.valueAt(i2)).get() == null) {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    sparseArray.remove(((Integer) arrayList.get(i3)).intValue());
                }
            }
            ClickableSpan[] clickableSpans = getClickableSpans(charSequence);
            if (clickableSpans != null && clickableSpans.length > 0) {
                getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", androidx.core.R.id.accessibility_action_clickable_span);
                int i4 = androidx.core.R.id.tag_accessibility_clickable_spans;
                SparseArray sparseArray2 = (SparseArray) view.getTag(i4);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    view.setTag(i4, sparseArray2);
                }
                for (int i5 = 0; i5 < clickableSpans.length; i5++) {
                    ClickableSpan clickableSpan = clickableSpans[i5];
                    int i6 = 0;
                    while (true) {
                        if (i6 < sparseArray2.size()) {
                            if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i6)).get())) {
                                i = sparseArray2.keyAt(i6);
                                break;
                            }
                            i6++;
                        } else {
                            i = f3947c;
                            f3947c = i + 1;
                            break;
                        }
                    }
                    sparseArray2.put(i, new WeakReference(clickableSpans[i5]));
                    ClickableSpan clickableSpan2 = clickableSpans[i5];
                    Spanned spanned = (Spanned) charSequence;
                    m923a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                    m923a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                    m923a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                    m923a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
                }
            }
        }
    }

    /* renamed from: c */
    public final boolean m924c(int i) {
        Bundle extras = getExtras();
        if (extras == null || (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) != i) {
            return false;
        }
        return true;
    }

    public boolean canOpenPopup() {
        return this.f3948a.canOpenPopup();
    }

    /* renamed from: d */
    public final void m925d(int i, boolean z) {
        Bundle extras = getExtras();
        if (extras != null) {
            int i2 = extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f3948a;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.f3948a;
        if (accessibilityNodeInfo2 == null) {
            if (accessibilityNodeInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo2.equals(accessibilityNodeInfo)) {
            return false;
        }
        if (this.f3949b == accessibilityNodeInfoCompat.f3949b && this.mParentVirtualDescendantId == accessibilityNodeInfoCompat.mParentVirtualDescendantId) {
            return true;
        }
        return false;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        ArrayList arrayList = new ArrayList();
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = this.f3948a.findAccessibilityNodeInfosByText(str);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(wrap(findAccessibilityNodeInfosByText.get(i)));
        }
        return arrayList;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = this.f3948a.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        Iterator<AccessibilityNodeInfo> it = findAccessibilityNodeInfosByViewId.iterator();
        while (it.hasNext()) {
            arrayList.add(wrap(it.next()));
        }
        return arrayList;
    }

    public AccessibilityNodeInfoCompat findFocus(int i) {
        return m922e(this.f3948a.findFocus(i));
    }

    public AccessibilityNodeInfoCompat focusSearch(int i) {
        return m922e(this.f3948a.focusSearch(i));
    }

    public List<AccessibilityActionCompat> getActionList() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f3948a.getActionList();
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new AccessibilityActionCompat(actionList.get(i), 0, null, null, null));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    @Deprecated
    public int getActions() {
        return this.f3948a.getActions();
    }

    @NonNull
    public List<String> getAvailableExtraData() {
        List<String> availableExtraData;
        if (Build.VERSION.SDK_INT >= 26) {
            availableExtraData = this.f3948a.getAvailableExtraData();
            return availableExtraData;
        }
        return Collections.emptyList();
    }

    @Deprecated
    public void getBoundsInParent(Rect rect) {
        this.f3948a.getBoundsInParent(rect);
    }

    public void getBoundsInScreen(Rect rect) {
        this.f3948a.getBoundsInScreen(rect);
    }

    public void getBoundsInWindow(@NonNull Rect rect) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 34) {
            AbstractC1821t3.m7438b(accessibilityNodeInfo, rect);
            return;
        }
        Rect rect2 = (Rect) accessibilityNodeInfo.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public AccessibilityNodeInfoCompat getChild(int i) {
        return m922e(this.f3948a.getChild(i));
    }

    public int getChildCount() {
        return this.f3948a.getChildCount();
    }

    public CharSequence getClassName() {
        return this.f3948a.getClassName();
    }

    public CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo = this.f3948a.getCollectionInfo();
        if (collectionInfo != null) {
            return new CollectionInfoCompat(collectionInfo);
        }
        return null;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.f3948a.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new CollectionItemInfoCompat(collectionItemInfo);
        }
        return null;
    }

    @Nullable
    public CharSequence getContainerTitle() {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 34) {
            return AbstractC1821t3.m7439c(accessibilityNodeInfo);
        }
        return accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public CharSequence getContentDescription() {
        return this.f3948a.getContentDescription();
    }

    public int getDrawingOrder() {
        if (Build.VERSION.SDK_INT >= 24) {
            return AbstractC1608o3.m6415c(this.f3948a);
        }
        return 0;
    }

    public CharSequence getError() {
        return this.f3948a.getError();
    }

    @Nullable
    public AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo() {
        if (Build.VERSION.SDK_INT >= 33) {
            return AbstractC0203d.m931e(this.f3948a);
        }
        return null;
    }

    public Bundle getExtras() {
        return this.f3948a.getExtras();
    }

    @Nullable
    public CharSequence getHintText() {
        CharSequence hintText;
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 26) {
            hintText = accessibilityNodeInfo.getHintText();
            return hintText;
        }
        return accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY");
    }

    @Deprecated
    public Object getInfo() {
        return this.f3948a;
    }

    public int getInputType() {
        return this.f3948a.getInputType();
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return m922e(this.f3948a.getLabelFor());
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return m922e(this.f3948a.getLabeledBy());
    }

    public int getLiveRegion() {
        return this.f3948a.getLiveRegion();
    }

    public int getMaxTextLength() {
        return this.f3948a.getMaxTextLength();
    }

    public long getMinDurationBetweenContentChangesMillis() {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 34) {
            return AbstractC1821t3.m7440d(accessibilityNodeInfo);
        }
        return accessibilityNodeInfo.getExtras().getLong("androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY");
    }

    public int getMovementGranularities() {
        return this.f3948a.getMovementGranularities();
    }

    public CharSequence getPackageName() {
        return this.f3948a.getPackageName();
    }

    @Nullable
    public CharSequence getPaneTitle() {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 28) {
            return AbstractC1534m3.m6043y(accessibilityNodeInfo);
        }
        return accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY");
    }

    public AccessibilityNodeInfoCompat getParent() {
        return m922e(this.f3948a.getParent());
    }

    public RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo rangeInfo = this.f3948a.getRangeInfo();
        if (rangeInfo != null) {
            return new RangeInfoCompat(rangeInfo);
        }
        return null;
    }

    @Nullable
    public CharSequence getRoleDescription() {
        return this.f3948a.getExtras().getCharSequence("AccessibilityNodeInfo.roleDescription");
    }

    @Nullable
    public CharSequence getStateDescription() {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 30) {
            return AbstractC1784s3.m7320b(accessibilityNodeInfo);
        }
        return accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public CharSequence getText() {
        boolean isEmpty = m923a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (!isEmpty) {
            ArrayList m923a = m923a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            ArrayList m923a2 = m923a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            ArrayList m923a3 = m923a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            ArrayList m923a4 = m923a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(accessibilityNodeInfo.getText(), 0, accessibilityNodeInfo.getText().length()));
            for (int i = 0; i < m923a.size(); i++) {
                spannableString.setSpan(new AccessibilityClickableSpanCompat(((Integer) m923a4.get(i)).intValue(), this, getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) m923a.get(i)).intValue(), ((Integer) m923a2.get(i)).intValue(), ((Integer) m923a3.get(i)).intValue());
            }
            return spannableString;
        }
        return accessibilityNodeInfo.getText();
    }

    public int getTextSelectionEnd() {
        return this.f3948a.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        return this.f3948a.getTextSelectionStart();
    }

    @Nullable
    public CharSequence getTooltipText() {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 28) {
            return AbstractC1534m3.m6032n(accessibilityNodeInfo);
        }
        return accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = r2.f3948a.getTouchDelegateInfo();
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        if (Build.VERSION.SDK_INT >= 29 && touchDelegateInfo != null) {
            return new TouchDelegateInfoCompat(touchDelegateInfo);
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return m922e(this.f3948a.getTraversalAfter());
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return m922e(this.f3948a.getTraversalBefore());
    }

    @Nullable
    public String getUniqueId() {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 33) {
            return AbstractC0203d.m933g(accessibilityNodeInfo);
        }
        return accessibilityNodeInfo.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public String getViewIdResourceName() {
        return this.f3948a.getViewIdResourceName();
    }

    public AccessibilityWindowInfoCompat getWindow() {
        AccessibilityWindowInfo window = this.f3948a.getWindow();
        if (window != null) {
            return new AccessibilityWindowInfoCompat(window);
        }
        return null;
    }

    public int getWindowId() {
        return this.f3948a.getWindowId();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean hasRequestInitialAccessibilityFocus() {
        if (Build.VERSION.SDK_INT >= 34) {
            return AbstractC1821t3.m7441e(this.f3948a);
        }
        return m924c(32);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean isAccessibilityDataSensitive() {
        if (Build.VERSION.SDK_INT >= 34) {
            return AbstractC1821t3.m7442f(this.f3948a);
        }
        return m924c(64);
    }

    public boolean isAccessibilityFocused() {
        return this.f3948a.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.f3948a.isCheckable();
    }

    public boolean isChecked() {
        return this.f3948a.isChecked();
    }

    public boolean isClickable() {
        return this.f3948a.isClickable();
    }

    public boolean isContentInvalid() {
        return this.f3948a.isContentInvalid();
    }

    public boolean isContextClickable() {
        return this.f3948a.isContextClickable();
    }

    public boolean isDismissable() {
        return this.f3948a.isDismissable();
    }

    public boolean isEditable() {
        return this.f3948a.isEditable();
    }

    public boolean isEnabled() {
        return this.f3948a.isEnabled();
    }

    public boolean isFocusable() {
        return this.f3948a.isFocusable();
    }

    public boolean isFocused() {
        return this.f3948a.isFocused();
    }

    public boolean isGranularScrollingSupported() {
        return m924c(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }

    public boolean isHeading() {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC1534m3.m6040v(this.f3948a);
        }
        if (m924c(2)) {
            return true;
        }
        CollectionItemInfoCompat collectionItemInfo = getCollectionItemInfo();
        if (collectionItemInfo != null && collectionItemInfo.isHeading()) {
            return true;
        }
        return false;
    }

    public boolean isImportantForAccessibility() {
        if (Build.VERSION.SDK_INT >= 24) {
            return AbstractC1608o3.m6410B(this.f3948a);
        }
        return true;
    }

    public boolean isLongClickable() {
        return this.f3948a.isLongClickable();
    }

    public boolean isMultiLine() {
        return this.f3948a.isMultiLine();
    }

    public boolean isPassword() {
        return this.f3948a.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        if (Build.VERSION.SDK_INT >= 28) {
            return AbstractC1534m3.m6017C(this.f3948a);
        }
        return m924c(1);
    }

    public boolean isScrollable() {
        return this.f3948a.isScrollable();
    }

    public boolean isSelected() {
        return this.f3948a.isSelected();
    }

    public boolean isShowingHintText() {
        boolean isShowingHintText;
        if (Build.VERSION.SDK_INT >= 26) {
            isShowingHintText = this.f3948a.isShowingHintText();
            return isShowingHintText;
        }
        return m924c(4);
    }

    public boolean isTextEntryKey() {
        boolean isTextEntryKey;
        if (Build.VERSION.SDK_INT >= 29) {
            isTextEntryKey = this.f3948a.isTextEntryKey();
            return isTextEntryKey;
        }
        return m924c(8);
    }

    public boolean isTextSelectable() {
        if (Build.VERSION.SDK_INT >= 33) {
            return AbstractC0203d.m934h(this.f3948a);
        }
        return m924c(8388608);
    }

    public boolean isVisibleToUser() {
        return this.f3948a.isVisibleToUser();
    }

    public boolean performAction(int i) {
        return this.f3948a.performAction(i);
    }

    @Deprecated
    public void recycle() {
    }

    public boolean refresh() {
        return this.f3948a.refresh();
    }

    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        return this.f3948a.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f3950a);
    }

    public boolean removeChild(View view) {
        return this.f3948a.removeChild(view);
    }

    public void setAccessibilityDataSensitive(boolean z) {
        if (Build.VERSION.SDK_INT >= 34) {
            AbstractC1821t3.m7443g(this.f3948a, z);
        } else {
            m925d(64, z);
        }
    }

    public void setAccessibilityFocused(boolean z) {
        this.f3948a.setAccessibilityFocused(z);
    }

    public void setAvailableExtraData(@NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3948a.setAvailableExtraData(list);
        }
    }

    @Deprecated
    public void setBoundsInParent(Rect rect) {
        this.f3948a.setBoundsInParent(rect);
    }

    public void setBoundsInScreen(Rect rect) {
        this.f3948a.setBoundsInScreen(rect);
    }

    public void setBoundsInWindow(@NonNull Rect rect) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 34) {
            AbstractC1821t3.m7444h(accessibilityNodeInfo, rect);
        } else {
            accessibilityNodeInfo.getExtras().putParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY", rect);
        }
    }

    public void setCanOpenPopup(boolean z) {
        this.f3948a.setCanOpenPopup(z);
    }

    public void setCheckable(boolean z) {
        this.f3948a.setCheckable(z);
    }

    public void setChecked(boolean z) {
        this.f3948a.setChecked(z);
    }

    public void setClassName(CharSequence charSequence) {
        this.f3948a.setClassName(charSequence);
    }

    public void setClickable(boolean z) {
        this.f3948a.setClickable(z);
    }

    public void setCollectionInfo(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        if (obj == null) {
            collectionInfo = null;
        } else {
            collectionInfo = ((CollectionInfoCompat) obj).f3953a;
        }
        this.f3948a.setCollectionInfo(collectionInfo);
    }

    public void setCollectionItemInfo(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (obj == null) {
            collectionItemInfo = null;
        } else {
            collectionItemInfo = ((CollectionItemInfoCompat) obj).f3954a;
        }
        this.f3948a.setCollectionItemInfo(collectionItemInfo);
    }

    public void setContainerTitle(@Nullable CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 34) {
            AbstractC1821t3.m7445i(accessibilityNodeInfo, charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY", charSequence);
        }
    }

    public void setContentDescription(CharSequence charSequence) {
        this.f3948a.setContentDescription(charSequence);
    }

    public void setContentInvalid(boolean z) {
        this.f3948a.setContentInvalid(z);
    }

    public void setContextClickable(boolean z) {
        this.f3948a.setContextClickable(z);
    }

    public void setDismissable(boolean z) {
        this.f3948a.setDismissable(z);
    }

    public void setDrawingOrder(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            AbstractC1608o3.m6434v(this.f3948a, i);
        }
    }

    public void setEditable(boolean z) {
        this.f3948a.setEditable(z);
    }

    public void setEnabled(boolean z) {
        this.f3948a.setEnabled(z);
    }

    public void setError(CharSequence charSequence) {
        this.f3948a.setError(charSequence);
    }

    public void setFocusable(boolean z) {
        this.f3948a.setFocusable(z);
    }

    public void setFocused(boolean z) {
        this.f3948a.setFocused(z);
    }

    public void setGranularScrollingSupported(boolean z) {
        m925d(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL, z);
    }

    public void setHeading(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            AbstractC1534m3.m6016B(this.f3948a, z);
        } else {
            m925d(2, z);
        }
    }

    public void setHintText(@Nullable CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 26) {
            accessibilityNodeInfo.setHintText(charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void setImportantForAccessibility(boolean z) {
        if (Build.VERSION.SDK_INT >= 24) {
            AbstractC1608o3.m6435w(this.f3948a, z);
        }
    }

    public void setInputType(int i) {
        this.f3948a.setInputType(i);
    }

    public void setLabelFor(View view) {
        this.f3948a.setLabelFor(view);
    }

    public void setLabeledBy(View view) {
        this.f3948a.setLabeledBy(view);
    }

    public void setLiveRegion(int i) {
        this.f3948a.setLiveRegion(i);
    }

    public void setLongClickable(boolean z) {
        this.f3948a.setLongClickable(z);
    }

    public void setMaxTextLength(int i) {
        this.f3948a.setMaxTextLength(i);
    }

    public void setMinDurationBetweenContentChangesMillis(long j) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 34) {
            AbstractC1821t3.m7446j(accessibilityNodeInfo, j);
        } else {
            accessibilityNodeInfo.getExtras().putLong("androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY", j);
        }
    }

    public void setMovementGranularities(int i) {
        this.f3948a.setMovementGranularities(i);
    }

    public void setMultiLine(boolean z) {
        this.f3948a.setMultiLine(z);
    }

    public void setPackageName(CharSequence charSequence) {
        this.f3948a.setPackageName(charSequence);
    }

    public void setPaneTitle(@Nullable CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 28) {
            AbstractC1534m3.m6038t(accessibilityNodeInfo, charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void setParent(View view) {
        this.mParentVirtualDescendantId = -1;
        this.f3948a.setParent(view);
    }

    public void setPassword(boolean z) {
        this.f3948a.setPassword(z);
    }

    public void setQueryFromAppProcessEnabled(@NonNull View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 34) {
            AbstractC1821t3.m7447k(this.f3948a, view, z);
        }
    }

    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        this.f3948a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.f3963a);
    }

    @SuppressLint({"GetterSetterNames"})
    public void setRequestInitialAccessibilityFocus(boolean z) {
        if (Build.VERSION.SDK_INT >= 34) {
            AbstractC1821t3.m7448l(this.f3948a, z);
        } else {
            m925d(32, z);
        }
    }

    public void setRoleDescription(@Nullable CharSequence charSequence) {
        this.f3948a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public void setScreenReaderFocusable(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            AbstractC1534m3.m6039u(this.f3948a, z);
        } else {
            m925d(1, z);
        }
    }

    public void setScrollable(boolean z) {
        this.f3948a.setScrollable(z);
    }

    public void setSelected(boolean z) {
        this.f3948a.setSelected(z);
    }

    public void setShowingHintText(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3948a.setShowingHintText(z);
        } else {
            m925d(4, z);
        }
    }

    public void setSource(View view) {
        this.f3949b = -1;
        this.f3948a.setSource(view);
    }

    public void setStateDescription(@Nullable CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 30) {
            AbstractC1784s3.m7321c(accessibilityNodeInfo, charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void setText(CharSequence charSequence) {
        this.f3948a.setText(charSequence);
    }

    public void setTextEntryKey(boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3948a.setTextEntryKey(z);
        } else {
            m925d(8, z);
        }
    }

    public void setTextSelectable(boolean z) {
        if (Build.VERSION.SDK_INT >= 33) {
            AbstractC0203d.m935i(this.f3948a, z);
        } else {
            m925d(8388608, z);
        }
    }

    public void setTextSelection(int i, int i2) {
        this.f3948a.setTextSelection(i, i2);
    }

    public void setTooltipText(@Nullable CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 28) {
            AbstractC1534m3.m6015A(accessibilityNodeInfo, charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY", charSequence);
        }
    }

    public void setTouchDelegateInfo(@NonNull TouchDelegateInfoCompat touchDelegateInfoCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3948a.setTouchDelegateInfo(touchDelegateInfoCompat.f3964a);
        }
    }

    public void setTraversalAfter(View view) {
        this.f3948a.setTraversalAfter(view);
    }

    public void setTraversalBefore(View view) {
        this.f3948a.setTraversalBefore(view);
    }

    public void setUniqueId(@Nullable String str) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3948a;
        if (i >= 33) {
            AbstractC0203d.m936j(accessibilityNodeInfo, str);
        } else {
            accessibilityNodeInfo.getExtras().putString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY", str);
        }
    }

    public void setViewIdResourceName(String str) {
        this.f3948a.setViewIdResourceName(str);
    }

    public void setVisibleToUser(boolean z) {
        this.f3948a.setVisibleToUser(z);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        getBoundsInWindow(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(getPackageName());
        sb.append("; className: ");
        sb.append(getClassName());
        sb.append("; text: ");
        sb.append(getText());
        sb.append("; error: ");
        sb.append(getError());
        sb.append("; maxTextLength: ");
        sb.append(getMaxTextLength());
        sb.append("; stateDescription: ");
        sb.append(getStateDescription());
        sb.append("; contentDescription: ");
        sb.append(getContentDescription());
        sb.append("; tooltipText: ");
        sb.append(getTooltipText());
        sb.append("; viewIdResName: ");
        sb.append(getViewIdResourceName());
        sb.append("; uniqueId: ");
        sb.append(getUniqueId());
        sb.append("; checkable: ");
        sb.append(isCheckable());
        sb.append("; checked: ");
        sb.append(isChecked());
        sb.append("; focusable: ");
        sb.append(isFocusable());
        sb.append("; focused: ");
        sb.append(isFocused());
        sb.append("; selected: ");
        sb.append(isSelected());
        sb.append("; clickable: ");
        sb.append(isClickable());
        sb.append("; longClickable: ");
        sb.append(isLongClickable());
        sb.append("; contextClickable: ");
        sb.append(isContextClickable());
        sb.append("; enabled: ");
        sb.append(isEnabled());
        sb.append("; password: ");
        sb.append(isPassword());
        sb.append("; scrollable: " + isScrollable());
        sb.append("; containerTitle: ");
        sb.append(getContainerTitle());
        sb.append("; granularScrollingSupported: ");
        sb.append(isGranularScrollingSupported());
        sb.append("; importantForAccessibility: ");
        sb.append(isImportantForAccessibility());
        sb.append("; visible: ");
        sb.append(isVisibleToUser());
        sb.append("; isTextSelectable: ");
        sb.append(isTextSelectable());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(isAccessibilityDataSensitive());
        sb.append("; [");
        List<AccessibilityActionCompat> actionList = getActionList();
        for (int i = 0; i < actionList.size(); i++) {
            AccessibilityActionCompat accessibilityActionCompat = actionList.get(i);
            String m921b = m921b(accessibilityActionCompat.getId());
            if (m921b.equals("ACTION_UNKNOWN") && accessibilityActionCompat.getLabel() != null) {
                m921b = accessibilityActionCompat.getLabel().toString();
            }
            sb.append(m921b);
            if (i != actionList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.f3948a;
    }

    /* loaded from: classes.dex */
    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;

        /* renamed from: a */
        public final Object f3963a;

        public RangeInfoCompat(AccessibilityNodeInfo.RangeInfo rangeInfo) {
            this.f3963a = rangeInfo;
        }

        public static RangeInfoCompat obtain(int i, float f, float f2, float f3) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i, f, f2, f3));
        }

        public float getCurrent() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f3963a).getCurrent();
        }

        public float getMax() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f3963a).getMax();
        }

        public float getMin() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f3963a).getMin();
        }

        public int getType() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f3963a).getType();
        }

        public RangeInfoCompat(int i, float f, float f2, float f3) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f3963a = AbstractC1784s3.m7319a(i, f, f2, f3);
            } else {
                this.f3963a = AccessibilityNodeInfo.RangeInfo.obtain(i, f, f2, f3);
            }
        }
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i) {
        return m922e(AccessibilityNodeInfo.obtain(view, i));
    }

    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        this.f3948a.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f3950a);
    }

    public void addChild(View view, int i) {
        this.f3948a.addChild(view, i);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getChild(int i, int i2) {
        if (Build.VERSION.SDK_INT >= 33) {
            return AbstractC0203d.m928b(this.f3948a, i, i2);
        }
        return getChild(i);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getParent(int i) {
        if (Build.VERSION.SDK_INT >= 33) {
            return AbstractC0203d.m932f(this.f3948a, i);
        }
        return getParent();
    }

    public boolean performAction(int i, Bundle bundle) {
        return this.f3948a.performAction(i, bundle);
    }

    public boolean removeChild(View view, int i) {
        return this.f3948a.removeChild(view, i);
    }

    public void setLabelFor(View view, int i) {
        this.f3948a.setLabelFor(view, i);
    }

    public void setLabeledBy(View view, int i) {
        this.f3948a.setLabeledBy(view, i);
    }

    public void setTraversalAfter(View view, int i) {
        this.f3948a.setTraversalAfter(view, i);
    }

    public void setTraversalBefore(View view, int i) {
        this.f3948a.setTraversalBefore(view, i);
    }

    public void setParent(View view, int i) {
        this.mParentVirtualDescendantId = i;
        this.f3948a.setParent(view, i);
    }

    public void setSource(View view, int i) {
        this.f3949b = i;
        this.f3948a.setSource(view, i);
    }

    /* loaded from: classes.dex */
    public static final class TouchDelegateInfoCompat {

        /* renamed from: a */
        public final AccessibilityNodeInfo.TouchDelegateInfo f3964a;

        public TouchDelegateInfoCompat(@NonNull Map<Region, View> map) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f3964a = AbstractC1497l3.m5829g(map);
            } else {
                this.f3964a = null;
            }
        }

        @Nullable
        public Region getRegionAt(@IntRange(from = 0) int i) {
            Region regionAt;
            if (Build.VERSION.SDK_INT >= 29) {
                regionAt = this.f3964a.getRegionAt(i);
                return regionAt;
            }
            return null;
        }

        @IntRange(from = 0)
        public int getRegionCount() {
            int regionCount;
            if (Build.VERSION.SDK_INT >= 29) {
                regionCount = this.f3964a.getRegionCount();
                return regionCount;
            }
            return 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
        
            r3 = r2.f3964a.getTargetForRegion(r3);
         */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region region) {
            AccessibilityNodeInfo targetForRegion;
            if (Build.VERSION.SDK_INT >= 29 && targetForRegion != null) {
                return AccessibilityNodeInfoCompat.wrap(targetForRegion);
            }
            return null;
        }

        public TouchDelegateInfoCompat(AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.f3964a = touchDelegateInfo;
        }
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    public AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f3948a = accessibilityNodeInfo;
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrap(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f3948a));
    }
}
