var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var motors = /** @class */ (function () {
    function motors(id, no, tnk) {
        this.id = id;
        this.no_wheels = no;
        this.tank_size = tnk;
    }
    motors.prototype.get_motor_type = function () {
        if (this.no_wheels == 4) {
            return 'car';
        }
        else if (this.no_wheels == 2) {
            return 'bike';
        }
        else {
            return 'havy vihicles';
        }
    };
    return motors;
}());
var bikes = /** @class */ (function (_super) {
    __extends(bikes, _super);
    function bikes(id, no, tnk, abs, cc) {
        return _super.call(this, id, no, tnk) || this;
        // this.abs=abs;
        // this.cc=cc;
    }
    return bikes;
}(motors));
var bb = new bikes(1, 2, 21, "true", 23);
console.log(bb.get_motor_type());
console.log(bb.abs);
