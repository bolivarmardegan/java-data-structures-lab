#!/usr/bin/env python3
"""Plot the CSV emitted by SortingBenchmarks; needs matplotlib."""
import csv
import sys
from pathlib import Path
import matplotlib.pyplot as plt

def main():
    if len(sys.argv) != 3:
        raise SystemExit("Usage: python3 scripts/plot_benchmarks.py benchmarks/results.csv docs/assets")
    source, output = Path(sys.argv[1]), Path(sys.argv[2])
    output.mkdir(parents=True, exist_ok=True)
    rows = list(csv.DictReader(source.open(encoding='utf8')))
    if not rows:
        raise SystemExit("CSV has no measurements")
    for scale in ('linear', 'log'):
        fig, ax = plt.subplots(figsize=(10, 5.5))
        for algorithm in sorted(set(r['algorithm'] for r in rows)):
            samples = sorted((int(r['n']), float(r['median_ms'])) for r in rows if r['algorithm'] == algorithm)
            ax.plot([x[0] for x in samples], [x[1] for x in samples], marker='o', label=algorithm)
        ax.set(xlabel='Array size (n)', ylabel='Median elapsed time (ms)', title=f'Java 21 sorting algorithms — {scale} scale')
        ax.set_yscale(scale)
        ax.grid(alpha=.25)
        ax.legend(ncol=2, fontsize=8)
        fig.tight_layout()
        fig.savefig(output/f'sorting_{scale}.png',dpi=145)
        plt.close(fig)

if __name__=='__main__':
    main()
