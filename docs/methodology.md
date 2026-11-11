# Benchmark methodology and caveats

The included benchmark is an educational **manual microbenchmark**, not JMH.

- Compiler/runtime: record the Java version and CPU in `benchmarks/environment.md`.
- Inputs: pseudo-random integers from `Random(20261111 + n)`, range [-50,000, 49,999].
- Each sorting algorithm sorts an independent *clone* of identical inputs.
- Four warm-up calls, seven timed calls, **median**, milliseconds.
- Dataset sizes: 100, 500, 1000, 2000, 5000, 10000. Quadratic sorts skip the largest sizes.
- `CountingSort` is optimized for **bounded key ranges**; distributions and range affect results.
- Input generation, cloning and validation are excluded from measured intervals.
- JIT, GC, CPU throttling and JVM startup can distort times; the CPU governor and system load are uncontrolled.
- **These numbers are samples, not complexity guarantees or proof of superiority.** For publishable measurements use JMH with forks/warmup and repeat on different machines.
- Do not compare algorithms only by wall-clock time: space, stability and adversarial inputs matter.

To regenerate from Maven build:

```bash
mvn -q -DskipTests compile
java -cp target/classes dev.learning.dsa.benchmarks.SortingBenchmarks > benchmarks/results.csv
python3 -m pip install matplotlib
python3 scripts/plot_benchmarks.py benchmarks/results.csv docs/assets
```
