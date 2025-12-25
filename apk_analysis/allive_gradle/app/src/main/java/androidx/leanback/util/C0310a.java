package androidx.leanback.util;

import androidx.leanback.util.StateMachine;
import kotlinx.coroutines.DebugKt;

/* renamed from: androidx.leanback.util.a */
/* loaded from: classes.dex */
public final class C0310a {

    /* renamed from: a */
    public final StateMachine.State f5512a;

    /* renamed from: b */
    public final StateMachine.State f5513b;

    /* renamed from: c */
    public final StateMachine.Event f5514c;

    /* renamed from: d */
    public final StateMachine.Condition f5515d;

    /* renamed from: e */
    public int f5516e;

    public C0310a(StateMachine.State state, StateMachine.State state2, StateMachine.Event event) {
        this.f5516e = 0;
        if (event != null) {
            this.f5512a = state;
            this.f5513b = state2;
            this.f5514c = event;
            this.f5515d = null;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final String toString() {
        String str;
        StateMachine.Event event = this.f5514c;
        if (event != null) {
            str = event.f5504a;
        } else {
            StateMachine.Condition condition = this.f5515d;
            if (condition != null) {
                str = condition.f5503a;
            } else {
                str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
            }
        }
        return "[" + this.f5512a.f5505a + " -> " + this.f5513b.f5505a + " <" + str + ">]";
    }

    public C0310a(StateMachine.State state, StateMachine.State state2) {
        this.f5516e = 0;
        this.f5512a = state;
        this.f5513b = state2;
        this.f5514c = null;
        this.f5515d = null;
    }

    public C0310a(StateMachine.State state, StateMachine.State state2, StateMachine.Condition condition) {
        this.f5516e = 0;
        if (condition != null) {
            this.f5512a = state;
            this.f5513b = state2;
            this.f5514c = null;
            this.f5515d = condition;
            return;
        }
        throw new IllegalArgumentException();
    }
}
