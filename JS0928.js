// /*
// ex32)
let ar = [
    {
        n:'호랑이',
        a:10
    },
    {
        n:'코끼리',
        a:20
    },
    {
        n:'원숭이',
        a:30
    }
]
console.log(ar);

for (const key in ar) {
    console.log(key);
    let element = ar[key];
    console.log(element);
    console.log(element.n, element.a);
    console.log(element['n'], element['a']);
}

let sum = 0;
for (const v of ar) {
    sum += v.a;
}
console.log(sum);

let br = ar.map(
    (v, k)=> v.n + v.a
)

console.log(br);
// */

/*
// ex31)
let ar =[10, 20, 30];
console.log(ar);
for (const index in ar) {
    console.log(index, ar[index]);
}

for (const value of ar) {
    console.log(value);
}

// 배열은 forEach를 내장
ar.forEach(
    function(v,i){
        console.log(v, i);
});

ar.forEach(
    (v,i)=> {
        console.log(v, i);
});

// map => 기존 데이터 가공하여 새로운 데이터 생성 
// ***원본 데이터는 수정되지 않음***
let br = ar.map(
    (num)=> {
        return num*10;
    }
);

br = ar.map( num => num * 100 );
console.log(ar);
console.log(br);

let cr = [0, 1, 2, 3]
let dr = cr.map(
    num => {
        if(num % 2)
            return 'odd'
        else
            return 'even'
    }
);

dr = cr.map(
    num => {
        return (num % 2)? 'odd' : 'even'
    }
);

dr = cr.map(
    num => (num % 2)? 'odd' : 'even'
);

console.log(dr);
*/

/*
// ex30) 배열에 들어갈 수 있는 유형
let ar = [
    10,
    '호랑이',
    true,
    [10,20,30],
    {name:'독수리',age:10},
    function(){},
    undefined
]
console.log(ar);
*/

/*
// ex29) 배열 선언 Array
// 배열 선언 방식 1
let ar = [10,20,30];
console.log(ar);
console.log(ar.length);
console.log(typeof(ar)); // Array 가 아니라 Object 라고 출력
console.log(Array.isArray(ar)); // Boolean 형태로 배열 여부 알려줌

// 방식 2 (빈 배열)
let br = Array();

// 방식 3 (길이 지정)
let cr = Array(5);
console.log(cr.length);

// 방식 4 (선언, 초기화 동시에 number 요소 하나만 넣을 수 없음! 방식 3과 동일하기 때문)
let dr = Array(5,1,2,3);
console.log(dr.length);

let er = Array('5');
console.log(er.length);
*/

/*
// ex28) 객체 사용법 How to use Object
let obj = {
    a:10,
    b:20
}
console.log(Object.keys(obj));
console.log(Object.values(obj));

let obj01 = {
    c:10,
    d:20
}
let obj02 = {
    e:10,
    f:20
}

// 객체 병합 Object merge
let obj03 = Object.assign(obj,obj01,obj02);
console.log(obj03);

let obj04 ={...obj01,...obj02}
console.log(obj04);

let f1 = (o)=>{
    console.log(o.d);
}
f1({...obj01,...obj02});
*/

/*
// ex27)
let c ='tiger';
let obj = {
    a:10,
    [c]:30
}
obj.b=20;
console.log(obj);

obj['d'] = 40; 
console.log(obj.a, obj.b, obj.tiger, obj.d);

for (let i = 0; i < 4; i++) {
    obj['tiger'+i] = i*100;
}

console.log(obj);
*/

/*
// ex26)
let obj = {
    a:10,
    b:20,
    f1:function() {
        console.log(
            this.a,
            this.b
        );    
    },

    // f2:()=> {
    //     console.log(
    //         this.a,
    //         this.b
    //     );    
    // }
    // 람다에서 this 접근 불가 

    f2:function(){
        for (const key in this) {
            console.log(this[key]);
        }
    }
}
obj.f1();
obj.f2();
*/

/*
// ex25) Array(배열), Object(객체)  
// 배열         객체
// []           {}
// 인덱스 생성  속성생성
// forEach 사용 forEach 불가
// length 사용  length  불가

let t = {
    name:'호랑이',
    age:100,
    bl:true
}
console.log(t);
console.log(t.name, t.age, t.bl);
console.log(t['name'], t['age'], t['bl']);

for (const key in t) {
    console.log(key);
    console.log(t[key]);
}

console.log(1, t.name, t.age);

with(t){
    console.log(2, name, age);
}

let obj = {
    a:10,
    b:20,
    f1:()=>{console.log('f1');}
}

console.log(obj);

obj.b = 99;
obj.c = 30; // 없는 속성은 추가 되므로 주의 

console.log(obj);

delete(obj.b)
console.log(obj);

obj.f2 = ()=>{console.log('test');}
obj.f2();
delete(obj.f1);
console.log(obj);
*/


/*
// ex24) eval: 문자열을 명령어로 전환 일종의 구문 분석기 *가급적 사용 자제* 
let str = '';
str += 'let a = 10;';
str += 'console.log(a);';

console.log(str);
eval(str); 
*/

/*
// ex23) 비동기 함수 동기처리
for (let i = 0; i < 3; i++){
    ((x)=>{
        setTimeout(
            ()=>{
                console.log(x);
            }, 1000
        );
    }
    )(i);
}

for (let i = 0; i < 3; i++){
    setTimeout(() => {
        console.log(i);
    }, 1000);
}
*/

/*
// ex22) 비동기 함수 
console.log('1');

setTimeout(
    function(){
        console.log('3');
    },
    2000 // 순서상 2보다 3이 먼저 나와야 하지만 setTimeout =에서 
//2초 시간차를 두었기 때문에 3이 뒤에 나온다 이를 비동기 함수라고 한다 
);
console.log('2'); 

let i = 0;
let id = setInterval(()=>{
        console.log(i++);
    },1000 // n초에 한 번씩 이 함수를 call 해라 
)

setTimeout(
    ()=>{
        clearInterval(id);
    },
    5000 // n초 뒤에 지정한 인터벌 함수 정지 
)
console.log('4');
*/

/*
// ex21) return 생략
let f1 = function(){
    return 100;
}

let f2 = () => 100;

let f3 = () =>{
    return console.log('1');
}

let f4 = () => console.log('1');

// React 에서 자주 볼 수 있는 형식 
let t = () => () => 100;

t = () => () =>{
    return 100;
}

t = () =>{
    return () =>{
        return 100;
    } 
} 

console.log(t()());

t = (a) =>{
    return (b) =>{
        return a+b;
    } 
} 

t = (a) => (b) =>{
        return a+b;
} 

t = (a) => (b) => a+b; 

t = a => b => a+b; // 인수가 하나일 때만 괄호 생략 가능 

console.log(t(10)(20));

t = (a, c) => (b, d) => a * d + b * c; 

console.log(t(10, 2)(20, 3));
*/

/*
// ex20)
((a)=>{(b)=>{}})();

((a)=>{
    console.log(a);
    return (b)=>{
        console.log(b);
    }
})(1)(2);

((a)=>{
    console.log(a);
    let temp = (b)=>{
        console.log(b);
    }
    temp(a+1);
})(1);

((a)=>{((b)=>{})()})();

((a)=>{
    console.log(a);
    ((b)=>{
        console.log(b);
    })(a+1)
})(3);

let f1 = function(fc) {
    fc(10);
}

f1((a)=>{
    ((b)=>{
        console.log(a+b);
    })(20)
});
*/

/*
// ex19)
let f1 = function() {
    console.log('1');
}
f1();

f1 = (a)=>{ 
    console.log(a); 
}
f1(2);

let f2 = (a) => {
    console.log(a);
    let f3 = (b) => {
        console.log(b);
    }
    return f3;
}
f2(5)(6);
*/

/*
// ex18) close 함수 : 지역변수가 사라지지 않고 계속 사용할 수 있도록 연장시키는 것
let f1 = function() {
    let a = 100;
    return function() {
        console.log(a);
    }
}
f1()();
*/

/*
// ex17) 함수를 return 하는 함수, 연속 괄호 => ()()
let f1 = function(fc) {
    console.log('1');
    let f2 = function() {
        console.log('2');
    }
    return f2; // return f2(); 함수 f2 자체를 return, f2 함수 return 값을 return 
}
f1()(); // 함수 f2가 return 되고 그걸 ()로 실행 따라서 f2 return 값도 출력 된다

let f3 = function(fc) {
    console.log('3');
    
    return function() {
        console.log('4');
    };
}
f3()();

(function() {
    console.log('1');
    return function() {
        console.log('2');
    }
})()();
*/

/*
// ex16) call back 함수(콜백함수): 원의미는 운영체제가 call 하는 함수 
let f1 = function(fc) {
    console.log('1');
    fc();
}

let f2 = function() {
    console.log('2');
}

// 방법 1
f1(f2);

// 방법 2
f1(function(){
    console.log('3');
})

// 방법 3
f1(() => {
    console.log('4');
})
*/

/*
// ex 15) 함수 재정의, 내부함수 
// f1이 let 일 땐 재정의가 가능하나 const로 정의 된 경우 재정의 불가
// f2는 const 여도 재정의 가능한 건 f1의 내부함수이기 때문에
let f1 = function(){
    console.log('1');
    const f2 = function() {
        console.log('2');
    }
    f2();
}
f1();

f1 = function(){
    console.log('3');
    let f2 = function() {
        console.log('4');
    }
    f2();
}
f1();
*/