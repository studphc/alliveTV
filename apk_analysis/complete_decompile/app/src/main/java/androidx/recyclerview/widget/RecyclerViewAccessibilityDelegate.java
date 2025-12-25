package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* renamed from: d */
    public final RecyclerView f7246d;

    /* renamed from: e */
    public final ItemDelegate f7247e;

    /* loaded from: classes.dex */
    public static class ItemDelegate extends AccessibilityDelegateCompat {

        /* renamed from: d */
        public final RecyclerViewAccessibilityDelegate f7248d;

        /* renamed from: e */
        public final WeakHashMap f7249e = new WeakHashMap();

        public ItemDelegate(@NonNull RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f7248d = recyclerViewAccessibilityDelegate;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f7249e.get(view);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        @Nullable
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f7249e.get(view);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f7249e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View view, @NonNull @SuppressLint({"InvalidNullabilityOverride"}) AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = this.f7248d;
            if (!recyclerViewAccessibilityDelegate.f7246d.hasPendingAdapterUpdates()) {
                RecyclerView recyclerView = recyclerViewAccessibilityDelegate.f7246d;
                if (recyclerView.getLayoutManager() != null) {
                    recyclerView.getLayoutManager().m1731c(view, accessibilityNodeInfoCompat);
                    AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f7249e.get(view);
                    if (accessibilityDelegateCompat != null) {
                        accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                        return;
                    } else {
                        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                        return;
                    }
                }
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f7249e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f7249e.get(viewGroup);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View view, int i, @Nullable @SuppressLint({"InvalidNullabilityOverride"}) Bundle bundle) {
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = this.f7248d;
            if (!recyclerViewAccessibilityDelegate.f7246d.hasPendingAdapterUpdates()) {
                RecyclerView recyclerView = recyclerViewAccessibilityDelegate.f7246d;
                if (recyclerView.getLayoutManager() != null) {
                    AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f7249e.get(view);
                    if (accessibilityDelegateCompat != null) {
                        if (accessibilityDelegateCompat.performAccessibilityAction(view, i, bundle)) {
                            return true;
                        }
                    } else if (super.performAccessibilityAction(view, i, bundle)) {
                        return true;
                    }
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    RecyclerView recyclerView2 = layoutManager.f7163b;
                    return layoutManager.performAccessibilityActionForItem(recyclerView2.f7104c, recyclerView2.f7117i0, view, i, bundle);
                }
            }
            return super.performAccessibilityAction(view, i, bundle);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEvent(@NonNull View view, int i) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f7249e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEventUnchecked(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = (AccessibilityDelegateCompat) this.f7249e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public RecyclerViewAccessibilityDelegate(@NonNull RecyclerView recyclerView) {
        this.f7246d = recyclerView;
        AccessibilityDelegateCompat itemDelegate = getItemDelegate();
        if (itemDelegate != null && (itemDelegate instanceof ItemDelegate)) {
            this.f7247e = (ItemDelegate) itemDelegate;
        } else {
            this.f7247e = new ItemDelegate(this);
        }
    }

    @NonNull
    public AccessibilityDelegateCompat getItemDelegate() {
        return this.f7247e;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View view, @NonNull @SuppressLint({"InvalidNullabilityOverride"}) AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !this.f7246d.hasPendingAdapterUpdates()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View view, @NonNull @SuppressLint({"InvalidNullabilityOverride"}) AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        RecyclerView recyclerView = this.f7246d;
        if (!recyclerView.hasPendingAdapterUpdates() && recyclerView.getLayoutManager() != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            RecyclerView recyclerView2 = layoutManager.f7163b;
            layoutManager.onInitializeAccessibilityNodeInfo(recyclerView2.f7104c, recyclerView2.f7117i0, accessibilityNodeInfoCompat);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(@NonNull @SuppressLint({"InvalidNullabilityOverride"}) View view, int i, @Nullable @SuppressLint({"InvalidNullabilityOverride"}) Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f7246d;
        if (!recyclerView.hasPendingAdapterUpdates() && recyclerView.getLayoutManager() != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            RecyclerView recyclerView2 = layoutManager.f7163b;
            return layoutManager.performAccessibilityAction(recyclerView2.f7104c, recyclerView2.f7117i0, i, bundle);
        }
        return false;
    }
}
