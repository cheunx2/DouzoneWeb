// /*
// ex41) 생성자 함수(클래스) => new
function Func(){
    this.num = 100;
    this.obj =  {
        num:200,
        f1:()=>{
            console.log(this);
        },
        f2:function(){
            console.log(this);
        }
    }
}
let ins = new Func();
ins.obj.f1();
ins.obj.f2();

let o = {
    n:10,
    o2:{
        f3:()=>{
            console.log(this);
            console.log(this.n);
        }
    }
}
o.o2.f3();

// */


/*
// ex40)
// 객체 안헤서 애로우 함수 사용할 떄 this를 주의(사용하지 말자).
let obj = {
    num:100,
    func01:()=>{
        console.log(this);
        console.log(this.num);
    },
    func02:function(){
        console.log(this);
        console.log(this.num);
    },
    func03(){
        console.log(this);
        console.log(this.num);
    }
}

obj.func01();
obj.func02();
obj.func03();
*/

/*
//ex39) reduce 연습
let people = [
    { name: 'Alice', age: 21 },
    { name: 'Max', age:4 },
    { name: 'Jane', age: 23 },
    { name: 'James', age: 39 },
    { name: 'Jone', age: 37 },
];

function groupBy(objectArray, property) {
    return objectArray.reduce((acc, obj)=> {
        let key = obj[property];
        if (!acc[key]) acc[key] = [];
        acc[key].push(obj);
        return acc;
    }, {});
}
console.log(groupBy(people,'age'));

function groupByMax(objectArray, property) {
    return objectArray.reduce((acc, obj) => {
      return acc[property] > obj[property] ? acc : obj;
    }, {});
  }

var maxAgePeople = groupByMax(people, "age");
console.log(maxAgePeople);
*/

/*
// ex38) filter
// filer(함수) 함수 조건을 충족하는 value 만 return 
let ar = ['tiger','lion','cat','dog','ai','cat']

console.log(ar.filter(len=>len.length <4));

// reduce 함수 
// 객체 내의 값 인스턴스 개수 세기 
let cntAr = ar.reduce(
    (all, each)=>{
        all[each] = (each in all)? all[each]+1 : 1
        return all;
    },{}
);

console.log(cntAr);

// 속성으로 객체 분류하기 
let people = [
    { name: 'Alice', age: 21 },
    { name: 'Max', age: 20 },
    { name: 'Jane', age: 20 }
  ];

function groupBy(objectArray, property) {
    return objectArray.reduce((acc, obj)=> {
        let key = obj[property];
        if (!acc[key]) acc[key] = [];
        acc[key].push(obj);
        return acc;
    }, {});
}
console.log(groupBy(people,'age'));

// 배열 총합
let numar = [1,2,3,4,5,6,7,8,9,10];

let sum10 = numar.reduce(
    (num, n)=> num + n
)
console.log(sum10);

// reduce 로 filter 함수 구현
let makefilter = numar.reduce((a, n)=>{
        if(n%2) a.push(n);
        return a;
    },[]
);

console.log(makefilter);
*/


/*
// ex37) splice, indexOf, lastIndexOf, every, some
let ar = [1,2,3,4,5,6];
let br = ar.slice(2,4); // (시작 위치:끝나는 위치 + 1)
console.log(br);


//splice(시작 인덱스, 삭제할 인덱스 갯수, 시작 인덱스부터 입력할 항목)* 삭제한 항목 return
console.log(ar.splice(1,2,9));
console.log(ar);
// 0 이면 삭제 X
console.log(ar.splice(1,0,10,20,30));
console.log(ar);

// indexOf(인덱스를 찾고자 하는 항목)
// 있으면 인덱스, 없으면 -1 반환 
let cr = ['먼지', '봉지', '휴지', '요지']
console.log(cr.indexOf('먼지'));
console.log(cr.indexOf('순무'));

// 인덱스 1번에 봉지가 있니? true 1 false -1
console.log(cr.indexOf('봉지', 1));

// 뒤에서 부터 검색 (최신 데이터 검색시 속도 향상을 위해, 혹은 중복 데이터 검색시에도 사용)
console.log(cr.lastIndexOf('휴지'));

// every(함수) 모든 value 가 함수 만족하면 true 아니면 false
let dr = [1,2,3,4,5,61];

function func(value){
    return value < 40;
}
console.log(ar.every((value)=>value<40));
console.log(dr.every(func));

// some(함수) 하나라도 만족하면 true 모두 불만족시 false
let er = [1,3,5,7,9];

console.log(er.some(v=>v%2==0));
*/

/*
// ex36) join, reverse, sort, 숫자 정렬 
let ar = ['tiger', 'lion', 'cat'];
console.log(ar.join());
console.log(ar.join(''));
console.log(ar.join('-'));

// reverse()*
console.log(ar.reverse());
console.log(ar);
console.log(ar.reverse());
console.log(ar);

// shift()* 가장 마지막 항목 삭제
console.log(ar.shift());
console.log(ar);

// unshift()* 마지막에 항목 추가(append?)
console.log(ar.unshift('tiger'));
console.log(ar.unshift('tiger01', 'hippo'));
console.log(ar);

let br = [52, 80, 15, 217];
br.sort(); // 사전순 정렬이므로 52보다 217이 먼저 나옴 
console.log(br);

br.sort((a, b)=> a-b);
console.log(br);
*/

/*
// ex35) concat => 배열 병합 (중복도 가능)
let ar = [1, 2, 3];
let br = ar.concat(4);
console.log(ar);
console.log(br);

let cr = [3,4,5,6,7];
let dr = ar.concat(cr);
console.log(dr);

dr.push(cr);
console.log(dr);
dr.pop(cr);
console.log(dr);
*/

/*
// ex34) 배열 push pop
let ar = [52, 80, 15, 27];
// pop()* (* 원본 데이터가 손상 되는 함수 표시할 때 사용)
let num = ar.pop();
console.log(ar, num);

num = ar.push(20); // 들어간 배열의 길이 return 
console.log(ar);
*/

/*
// ex33) 배열 함수 
let ar = [52, 80, 15, 27];
console.log(ar, typeof(ar));

let br = ar.toString();
console.log(br, typeof(br));

let st01 = '52, 80, 15, 27';
console.log(st01, typeof(st01));

let date = new Date();
console.log(date);
console.log(date.toLocaleDateString());
*/