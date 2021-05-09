let findLatestStep = (A, T, seen = new Set(), ok = new Set(), last = -1) => {
  A = A.map(i => i - 1);
  let aLength = A.length;
  let P = [...Array(N).keys()];
  let L = Array(N).fill(1);
  const find = (x) => {
    return P[x] = x == P[x] ? P[x] : find(P[x])
  };
  const union = (a, b) => {
    a = find(a);
    b = find(b);
    P[b] = a;  
    return L[a] = L[b];
  };
  let step = 1;
  for (let i of A) {
    seen.add(i);
    if (0 < i) {
      ok.delete(find(P[i - 1]));
    } else if (i + 1 < aLength) {
      ok.delete(find(P[i + 1]));
    } else if (seen.has(i - 1)) {
      L[i] = union(i, i - 1);
    } else if (seen.has(i + 1)) {
    L[i] = union(i, i + 1);
    } else if (L[i] == T) {
      ok.add(i);  
    } else if (ok.size) {
      last = step;
    }
    ++step;
  }
  return last;
};
