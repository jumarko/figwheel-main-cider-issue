# figwheel-main-cider-issue
A reproducer for CLJS repl issue "Null closurePrimitiveNames" with Emacs/Cider &amp; its enrich.classpath plugin

See cider issue: https://github.com/clojure-emacs/cider/issues/3167

## Dependencies

### pure lein deps

```
lein deps :tree > deps.out
```

See [deps.out](deps.out).

### lein + cider deps

```
lein update-in :dependencies conj \[nrepl/nrepl\ \"0.9.0\"\] -- update-in :dependencies conj \[refactor-nrepl/refactor-nrepl\ \"3.3.2\"\] -- update-in :dependencies conj \[cider/piggieback\ \"0.5.2\"\] -- update-in :plugins conj \[refactor-nrepl/refactor-nrepl\ \"3.3.2\"\] -- update-in :plugins conj \[cider/cider-nrepl\ \"0.28.1\"\] -- update-in :plugins conj \[mx.cider/enrich-classpath\ \"1.9.0\"\] -- update-in :middleware conj cider.enrich-classpath/middleware -- deps :tree >& deps-cider.out
```

See [deps-cider.out](deps-cider.out).

You'll see that deps-cider.out contains a lot more things (sources and javadocs).
This one stands out and I believe it's the source of the problem:
```
[com.google.javascript/closure-compiler "v20130603" :classifier "sources" :exclusions [[*]]]
```
Again, it's only present when `enrich-classpath` is used.

