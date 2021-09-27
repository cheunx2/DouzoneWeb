function t1(){
    console.log('1');
}

function t2(n, s){
    console.log(n+s);
}

function t3(){
    console.log('3');
    return 888;
}

function t4(n){
    console.log('4');
    return n*2;
}

t1();
t2(1,'호랑이');
console.log(t3());
console.log(t4(10));

function t5(){
    console.log(typeof(arguments));
    console.log(arguments.length);
    let sum = 0;

    for (let key of arguments) { // of 는 value in 은 인덱스 값 
        sum += key;
    }
    console.log(sum);
}
t5(10,20,30)

/*
// ex13) 함수 정의 2
let f3 = (()=>{
    console.log('5');    
})();

function f4(num){
    console.log(num);
}
f4(100);

(function(num){
    console.log(num);
})(200);

(function(dt){
    let start = new Date().getTime();
    while(new Date().getTime()< start + dt);
})(1000);
console.log('test');

// 함수 첫 글자를 대문자면 => 생성자 함수(자바 == 클래스) 
function Fff555() {
    this.num1 = 10
    this.num2 = 20
    this.m1 = function(){
        console.log(this.num1);        
    }
    this.m2 = ()=>{
        console.log(this.num2);
    }
}; 

let ins = new Fff555();
ins.m1();
ins.m2();
*/

/*
// ex12) 함수 선언 방식
// fuction name 방식
f1(); // Hoisting 호이스팅(함수 선언 전에 사용) 가능 
function f1(){console.log('1');}

// Hoisting 불가 
let f2 = function(){console.log('2');}
f2();

// 람다함수로 함수 정의, 자주 사용 된다!! 
let f3 = ()=>{console.log('3');}
f3();

// 즉시 실행 함수(IIFE)
(function(){
    console.log('4');
})();
// function 앞뒤 괄호 == 이 함수는 곧 호출하겠다
// 뒤에 (); 바로 실행 중간에 뭐가 들어가면 안 됨

(()=>{
    console.log('5');
})();
*/

/*
// ex11) short if
let a = 10;
if(a > 3){
    console.log('test1');
}

a > 3 && console.log('test2');
// 상단 3줄 짜리 코드와 동일

if(!false){
    console.log('test3');
}

false || console.log('test4');
*/

/*
// ex10) 비교 연산자
console.log(100 == 100); // true
console.log(100 == '100'); // true
console.log(100 === '100'); // false
*/

/*
// ex09) 시간 확인, 시간 지연
let start = new Date().getTime();
console.log(start);

for (var i = 0; new Date().getTime() <start + 1000; i++) {
}
console.log(i);

// 시간 지연용으로 사용시
let start1 = new Date().getTime();
console.log(start1);
while (new Date().getTime()<start1+2000);
console.log("호랑이");
*/

/*
// ex08)
nn = new Date()
console.log(nn.getFullYear()+1,'월');
// 월 + 1 해야함 
console.log(nn.getDate(),'일');
console.log(nn.getDay(),'요일');
// 0(일) 1(월) 2(화)
console.log(nn.getHours(),'시');
console.log(nn.getMinutes(),'분');
console.log(nn.getSeconds(),'초');

console.log(typeof(nn)); // nn == object
console.log(typeof(Date)); // Date == function
*/

/*
// ex07) 제곱
console.log(2**3**2);// 2**3**2 => 2**9 => 512
console.log(2**9);
*/

/*
// ex06) 문자열
let str = "호랑이";
str += '독수리';

console.log(str);

let s = '1000'
let n = 1000;

console.log(typeof(s), typeof(n));
console.log(Number(s)+10); // 문자열을 숫자로
console.log(parseInt(s)+10); // Number 와 같은 기능
console.log(String(n)+10); // 숫자를 문자열로

// 문자열 숫자 변환 슈가코드 
let r1 = s;
let r2 = +s;
let r3 = +'2000';

console.log(typeof(r1), typeof(r2), typeof(r3));
*/

/*
// ex05)
var a = 10;
if(true){
    var a = 20;
    console.log(a);
    
}
console.log(a);

let b = 10;
if(true){
    let b = 20;
    console.log(b);
    
}
console.log(b);
// 20 20 20 10
// var 와 let 의 차이점 => 지역성 존재 유무 
*/

/*
// ex04)
let a = 10;
console.log(typeof(a));

a = '호랑이';
console.log(typeof(a));
// 이전 메모리가 사라지고 새로운 메모리로 저장된다. 
*/

/*
// ex03)
let obj ={
    a:{
        b:{
            c:10
        }
    }
}
console.log(obj.a.b.c);


let tiger = {
    a:10,
    b:'호랑이',
    c:true,
    d:[],
    e:{},
    f:function(){},
    g:undefined
};

console.log(tiger, typeof(tiger));
console.log(tiger.a, typeof(tiger.a));
*/

/*
// ex02)
let a = "호랑이";
let b = true;
let c = [];
let d = {};
let e = function(){};
let f = undefined;
let g = 10;

console.log(typeof(a));
console.log(typeof(b));
console.log(typeof(c));
console.log(typeof(d));
console.log(typeof(e));
console.log(typeof(f));
console.log(typeof(g));
console.log(typeof(3.14));
*/

/*
// ex01)
console.log("Hello World!");

var a = 10;
// 요즘은 var 타입 안 씀

let b = 20;
// var => let

const c = 30;4
// const == 상수이므로 항상 초기값 필요
 
console.log(a, b, c);
*/