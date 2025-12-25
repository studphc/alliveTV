package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class RequestTracker {

    /* renamed from: a */
    public final Set f8981a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    public final ArrayList f8982b = new ArrayList();

    /* renamed from: c */
    public boolean f8983c;

    public boolean clearAndRemove(@Nullable Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.f8981a.remove(request);
        if (!this.f8982b.remove(request) && !remove) {
            z = false;
        }
        if (z) {
            request.clear();
        }
        return z;
    }

    public void clearRequests() {
        Iterator it = Util.getSnapshot(this.f8981a).iterator();
        while (it.hasNext()) {
            clearAndRemove((Request) it.next());
        }
        this.f8982b.clear();
    }

    public boolean isPaused() {
        return this.f8983c;
    }

    public void pauseAllRequests() {
        this.f8983c = true;
        for (Request request : Util.getSnapshot(this.f8981a)) {
            if (request.isRunning() || request.isComplete()) {
                request.clear();
                this.f8982b.add(request);
            }
        }
    }

    public void pauseRequests() {
        this.f8983c = true;
        for (Request request : Util.getSnapshot(this.f8981a)) {
            if (request.isRunning()) {
                request.pause();
                this.f8982b.add(request);
            }
        }
    }

    public void restartRequests() {
        for (Request request : Util.getSnapshot(this.f8981a)) {
            if (!request.isComplete() && !request.isCleared()) {
                request.clear();
                if (!this.f8983c) {
                    request.begin();
                } else {
                    this.f8982b.add(request);
                }
            }
        }
    }

    public void resumeRequests() {
        this.f8983c = false;
        for (Request request : Util.getSnapshot(this.f8981a)) {
            if (!request.isComplete() && !request.isRunning()) {
                request.begin();
            }
        }
        this.f8982b.clear();
    }

    public void runRequest(@NonNull Request request) {
        this.f8981a.add(request);
        if (!this.f8983c) {
            request.begin();
            return;
        }
        request.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f8982b.add(request);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f8981a.size() + ", isPaused=" + this.f8983c + "}";
    }
}
