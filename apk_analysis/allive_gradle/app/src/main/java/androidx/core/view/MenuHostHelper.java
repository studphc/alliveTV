package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.an1;
import p000.y71;

/* loaded from: classes.dex */
public class MenuHostHelper {

    /* renamed from: a */
    public final Runnable f3886a;

    /* renamed from: b */
    public final CopyOnWriteArrayList f3887b = new CopyOnWriteArrayList();

    /* renamed from: c */
    public final HashMap f3888c = new HashMap();

    public MenuHostHelper(@NonNull Runnable runnable) {
        this.f3886a = runnable;
    }

    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.f3887b.add(menuProvider);
        this.f3886a.run();
    }

    public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        Iterator it = this.f3887b.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).onCreateMenu(menu, menuInflater);
        }
    }

    public void onMenuClosed(@NonNull Menu menu) {
        Iterator it = this.f3887b.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).onMenuClosed(menu);
        }
    }

    public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
        Iterator it = this.f3887b.iterator();
        while (it.hasNext()) {
            if (((MenuProvider) it.next()).onMenuItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void onPrepareMenu(@NonNull Menu menu) {
        Iterator it = this.f3887b.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).onPrepareMenu(menu);
        }
    }

    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.f3887b.remove(menuProvider);
        an1 an1Var = (an1) this.f3888c.remove(menuProvider);
        if (an1Var != null) {
            an1Var.f271a.removeObserver(an1Var.f272b);
            an1Var.f272b = null;
        }
        this.f3886a.run();
    }

    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
        addMenuProvider(menuProvider);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap hashMap = this.f3888c;
        an1 an1Var = (an1) hashMap.remove(menuProvider);
        if (an1Var != null) {
            an1Var.f271a.removeObserver(an1Var.f272b);
            an1Var.f272b = null;
        }
        hashMap.put(menuProvider, new an1(lifecycle, new y71(1, this, menuProvider)));
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull final MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull final Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap hashMap = this.f3888c;
        an1 an1Var = (an1) hashMap.remove(menuProvider);
        if (an1Var != null) {
            an1Var.f271a.removeObserver(an1Var.f272b);
            an1Var.f272b = null;
        }
        hashMap.put(menuProvider, new an1(lifecycle, new LifecycleEventObserver() { // from class: zm1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper menuHostHelper = MenuHostHelper.this;
                menuHostHelper.getClass();
                Lifecycle.State state2 = state;
                Lifecycle.Event upTo = Lifecycle.Event.upTo(state2);
                MenuProvider menuProvider2 = menuProvider;
                if (event == upTo) {
                    menuHostHelper.addMenuProvider(menuProvider2);
                    return;
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    menuHostHelper.removeMenuProvider(menuProvider2);
                } else if (event == Lifecycle.Event.downFrom(state2)) {
                    menuHostHelper.f3887b.remove(menuProvider2);
                    menuHostHelper.f3886a.run();
                }
            }
        }));
    }
}
