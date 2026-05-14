package c.c.a.a.h;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
