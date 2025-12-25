package androidx.leanback.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import p000.ye0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class StateMachine {
    public static final int STATUS_INVOKED = 1;
    public static final int STATUS_ZERO = 0;

    /* renamed from: a */
    public final ArrayList f5500a = new ArrayList();

    /* renamed from: b */
    public final ArrayList f5501b = new ArrayList();

    /* renamed from: c */
    public final ArrayList f5502c = new ArrayList();

    /* loaded from: classes.dex */
    public static class Condition {

        /* renamed from: a */
        public final String f5503a;

        public Condition(@NonNull String str) {
            this.f5503a = str;
        }

        public boolean canProceed() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class Event {

        /* renamed from: a */
        public final String f5504a;

        public Event(@NonNull String str) {
            this.f5504a = str;
        }
    }

    /* loaded from: classes.dex */
    public static class State {

        /* renamed from: a */
        public final String f5505a;

        /* renamed from: b */
        public final boolean f5506b;

        /* renamed from: c */
        public final boolean f5507c;

        /* renamed from: d */
        public int f5508d;

        /* renamed from: e */
        public int f5509e;

        /* renamed from: f */
        public ArrayList f5510f;

        /* renamed from: g */
        public ArrayList f5511g;

        public State(String str) {
            this(str, false, true);
        }

        /* renamed from: a */
        public final void m1377a(C0310a c0310a) {
            if (this.f5510f == null) {
                this.f5510f = new ArrayList();
            }
            this.f5510f.add(c0310a);
        }

        /* renamed from: b */
        public final void m1378b(C0310a c0310a) {
            if (this.f5511g == null) {
                this.f5511g = new ArrayList();
            }
            this.f5511g.add(c0310a);
        }

        public final int getStatus() {
            return this.f5508d;
        }

        public void run() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.f5505a);
            sb.append(" ");
            return ye0.m8298r(sb, "]", this.f5508d);
        }

        public State(String str, boolean z, boolean z2) {
            this.f5508d = 0;
            this.f5509e = 0;
            this.f5505a = str;
            this.f5506b = z;
            this.f5507c = z2;
        }
    }

    /* renamed from: a */
    public final void m1376a() {
        boolean z;
        Condition condition;
        do {
            ArrayList arrayList = this.f5502c;
            z = false;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                State state = (State) arrayList.get(size);
                if (state.f5508d != 1) {
                    ArrayList arrayList2 = state.f5510f;
                    if (arrayList2 != null) {
                        if (state.f5507c) {
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                if (((C0310a) it.next()).f5516e != 1) {
                                    break;
                                }
                            }
                        } else {
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                if (((C0310a) it2.next()).f5516e == 1) {
                                }
                            }
                        }
                    }
                    state.f5508d = 1;
                    state.run();
                    ArrayList arrayList3 = state.f5511g;
                    if (arrayList3 != null) {
                        Iterator it3 = arrayList3.iterator();
                        while (it3.hasNext()) {
                            C0310a c0310a = (C0310a) it3.next();
                            if (c0310a.f5514c == null && ((condition = c0310a.f5515d) == null || condition.canProceed())) {
                                state.f5509e++;
                                c0310a.f5516e = 1;
                                if (!state.f5506b) {
                                    break;
                                }
                            }
                        }
                    }
                    arrayList.remove(size);
                    this.f5501b.add(state);
                    z = true;
                }
            }
        } while (z);
    }

    public void addState(@NonNull State state) {
        ArrayList arrayList = this.f5500a;
        if (!arrayList.contains(state)) {
            arrayList.add(state);
        }
    }

    public void addTransition(@NonNull State state, @NonNull State state2, @NonNull Event event) {
        C0310a c0310a = new C0310a(state, state2, event);
        state2.m1377a(c0310a);
        state.m1378b(c0310a);
    }

    public void fireEvent(@NonNull Event event) {
        boolean z;
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f5501b;
            if (i < arrayList.size()) {
                State state = (State) arrayList.get(i);
                ArrayList arrayList2 = state.f5511g;
                if (arrayList2 != null && ((z = state.f5506b) || state.f5509e <= 0)) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        C0310a c0310a = (C0310a) it.next();
                        if (c0310a.f5516e != 1 && c0310a.f5514c == event) {
                            c0310a.f5516e = 1;
                            state.f5509e++;
                            if (!z) {
                                break;
                            }
                        }
                    }
                }
                i++;
            } else {
                m1376a();
                return;
            }
        }
    }

    public void reset() {
        this.f5502c.clear();
        this.f5501b.clear();
        Iterator it = this.f5500a.iterator();
        while (it.hasNext()) {
            State state = (State) it.next();
            state.f5508d = 0;
            state.f5509e = 0;
            ArrayList arrayList = state.f5511g;
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((C0310a) it2.next()).f5516e = 0;
                }
            }
        }
    }

    public void start() {
        this.f5502c.addAll(this.f5500a);
        m1376a();
    }

    public void addTransition(@NonNull State state, @NonNull State state2, @NonNull Condition condition) {
        C0310a c0310a = new C0310a(state, state2, condition);
        state2.m1377a(c0310a);
        state.m1378b(c0310a);
    }

    public void addTransition(@NonNull State state, @NonNull State state2) {
        C0310a c0310a = new C0310a(state, state2);
        state2.m1377a(c0310a);
        state.m1378b(c0310a);
    }
}
