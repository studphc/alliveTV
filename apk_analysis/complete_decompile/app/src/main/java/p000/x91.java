package p000;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class x91 {

    /* renamed from: b */
    public static final Logger f28480b = Logger.getLogger(x91.class.getName());

    /* renamed from: a */
    public final List f28481a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a */
    public final void m8151a() {
        boolean z;
        for (int i = 0; i < this.f28481a.size(); i++) {
            w91 w91Var = (w91) this.f28481a.get(i);
            synchronized (w91Var) {
                try {
                    if (!w91Var.f28106e) {
                        z = true;
                        w91Var.f28106e = true;
                    } else {
                        z = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                try {
                    w91Var.f28103b.execute(w91Var);
                } catch (RuntimeException e) {
                    synchronized (w91Var) {
                        w91Var.f28106e = false;
                        Logger logger = f28480b;
                        Level level = Level.SEVERE;
                        String valueOf = String.valueOf(w91Var.f28102a);
                        String valueOf2 = String.valueOf(w91Var.f28103b);
                        logger.log(level, AbstractC1726qj.m7055k(valueOf2.length() + valueOf.length() + 42, "Exception while running callbacks for ", valueOf, " on ", valueOf2), (Throwable) e);
                        throw e;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final void m8152b(v91 v91Var) {
        Preconditions.checkNotNull(v91Var, NotificationCompat.CATEGORY_EVENT);
        Preconditions.checkNotNull(v91Var, "label");
        synchronized (this.f28481a) {
            try {
                Iterator it = this.f28481a.iterator();
                while (it.hasNext()) {
                    ((w91) it.next()).m8011a(v91Var, v91Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
