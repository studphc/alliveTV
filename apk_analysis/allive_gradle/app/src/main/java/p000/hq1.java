package p000;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartReader;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

/* loaded from: classes2.dex */
public final class hq1 implements Source {

    /* renamed from: a */
    public final Timeout f18133a = new Timeout();

    /* renamed from: b */
    public final /* synthetic */ MultipartReader f18134b;

    public hq1(MultipartReader multipartReader) {
        this.f18134b = multipartReader;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        hq1 hq1Var;
        MultipartReader multipartReader = this.f18134b;
        hq1Var = multipartReader.f24005h;
        if (Intrinsics.areEqual(hq1Var, this)) {
            multipartReader.f24005h = null;
        }
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) {
        hq1 hq1Var;
        BufferedSource bufferedSource;
        long m6600a;
        BufferedSource bufferedSource2;
        long read;
        long m6600a2;
        BufferedSource bufferedSource3;
        long read2;
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j >= 0) {
            MultipartReader multipartReader = this.f18134b;
            hq1Var = multipartReader.f24005h;
            if (Intrinsics.areEqual(hq1Var, this)) {
                bufferedSource = multipartReader.f23998a;
                Timeout f24750a = bufferedSource.getF24750a();
                Timeout timeout = this.f18133a;
                long f24767c = f24750a.getF24767c();
                long minTimeout = Timeout.INSTANCE.minTimeout(timeout.getF24767c(), f24750a.getF24767c());
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                f24750a.timeout(minTimeout, timeUnit);
                if (f24750a.getF24765a()) {
                    long deadlineNanoTime = f24750a.deadlineNanoTime();
                    if (timeout.getF24765a()) {
                        f24750a.deadlineNanoTime(Math.min(f24750a.deadlineNanoTime(), timeout.deadlineNanoTime()));
                    }
                    try {
                        m6600a2 = multipartReader.m6600a(j);
                        if (m6600a2 != 0) {
                            bufferedSource3 = multipartReader.f23998a;
                            read2 = bufferedSource3.read(sink, m6600a2);
                        } else {
                            read2 = -1;
                        }
                        f24750a.timeout(f24767c, timeUnit);
                        if (timeout.getF24765a()) {
                            f24750a.deadlineNanoTime(deadlineNanoTime);
                        }
                        return read2;
                    } catch (Throwable th) {
                        f24750a.timeout(f24767c, TimeUnit.NANOSECONDS);
                        if (timeout.getF24765a()) {
                            f24750a.deadlineNanoTime(deadlineNanoTime);
                        }
                        throw th;
                    }
                }
                if (timeout.getF24765a()) {
                    f24750a.deadlineNanoTime(timeout.deadlineNanoTime());
                }
                try {
                    m6600a = multipartReader.m6600a(j);
                    if (m6600a != 0) {
                        bufferedSource2 = multipartReader.f23998a;
                        read = bufferedSource2.read(sink, m6600a);
                    } else {
                        read = -1;
                    }
                    f24750a.timeout(f24767c, timeUnit);
                    if (timeout.getF24765a()) {
                        f24750a.clearDeadline();
                    }
                    return read;
                } catch (Throwable th2) {
                    f24750a.timeout(f24767c, TimeUnit.NANOSECONDS);
                    if (timeout.getF24765a()) {
                        f24750a.clearDeadline();
                    }
                    throw th2;
                }
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(ye0.m8294n(j, "byteCount < 0: ").toString());
    }

    @Override // okio.Source
    /* renamed from: timeout */
    public final Timeout getF24750a() {
        return this.f18133a;
    }
}
