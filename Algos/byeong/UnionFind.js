class UnionFind {
  // UnionFind 구현체. ranks 의 경우 두 집합이 합쳐진 후 합쳐진 집합의 parent 가 가지고 있는 m 의 길이를 나타낸다.
  constructor(arr) {
    [this.parents, this.ranks] = this.init(arr);
  }

  init(arr) {
    const parents = new Map();
    const ranks = new Map();
    arr.forEach(e => {
        parents.set(e, e);
        ranks.set(e, 1);
    });
      
    return [parents, ranks];
  }

  find(cur) {
    if(this.parents.get(cur) === cur) return cur;
    // 모든 노드에서 바로 부모 노드를 바라보도록 해주는 코드(굳이 재귀적 링크를 탈 이유가 없다)
    this.parents.set(cur, this.find(this.parents.get(cur)));
    return this.parents.get(cur);
  }
  
  union(node1, node2) {
    const parent1 = this.find(node1);
    const parent2 = this.find(node2);
    if(parent1 === parent2) return;

    const [child, parent] = parent1 > parent2 ? [parent2, parent1] : [parent1, parent2];
    this.upsert(child, parent);
  }

  upsert(child, parent) {
    this.parents.set(child, parent);
    // 가장 중요한 부분. 1으로 갱신할 녀석의 rank 값과 좌/우에 해당하는 집합의 rank 갑을 더해준다.(rank === m)
    this.ranks.set(parent, this.ranks.get(parent) + this.ranks.get(child));
  }
}

/**
 * @param {number[]} arr
 * @param {number} m
 * @return {number}
 */
const findLatestStep = (arr, m) => {
    let answer = -1;
    const uf = new UnionFind(arr);
    const visited = new Set();
    // m 에 해당하는 값이 존재하는 집합을 따로 구하기 위한 Set 이다. 해당 Set이 비었다는 것은 모든 집합이 m 의 길이를 충족 못한다는 뜻이다.
  const mLengthSet = new Set(); 

  for(let i = 0; i < arr.length; i++) {
    const cur = arr[i];
    const params = {
      uf,
      cur,
      mLengthSet,
    };
    visited.add(cur);

    // 해당 노드의 좌/우가 visit 한 적이 있다면 반드시 집합이 있다는 뜻이므로 rank 를 갱신한다.
    if(visited.has(cur - 1)) go({...params, target: cur - 1});
    if(visited.has(cur + 1)) go({...params, target: cur + 1});

    const parent = uf.find(cur);
    // 해당 집합이 m 의 길이를 만족한다면 mSet 에 넣어주고 정답을 해당 시간(index)로 갱신한다.
    if(uf.ranks.get(parent) === m) mLengthSet.add(parent);
    if(mLengthSet.size > 0) answer = i + 1;
  }

  return answer;
}

const go = ({uf, mLengthSet, cur, target}) => {
    const curParent = uf.find(cur);
    const targetParent = uf.find(target);
    uf.union(curParent, targetParent);
    // 두 집합이 union 될 경우 반드시 m 보다 길이가 길어지므로 mSet 에서 지워준다.
    mLengthSet.delete(curParent);
    mLengthSet.delete(targetParent);
}
