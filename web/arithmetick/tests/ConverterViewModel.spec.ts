import { describe, expect, it } from "vitest";
import { ConverterViewModel } from "../src/lib/viewmodels/ConverterViewModel";
import {
  allCategoryCards,
  CategoryCard,
} from "../src/lib/models/CategoryItemModel";
import { Units } from "uom-units";

enum CategoryItems {
  LENGTH = 0,
  TEMPERATURE,
  MASS,
  VOLUME,
  PRESSURE,
  ENERGY,
}

describe("Length Conversion Tests", function () {
  let lengthCard =
    allCategoryCards.find((card) => card.item == CategoryItems.LENGTH) ??
    new CategoryCard(CategoryItems.LENGTH);
  it("check length outputs", function () {
    expect(lengthCard.title).toBe("Length");
    expect(lengthCard.icon).toBe("fas fa-ruler");
    expect(lengthCard.colors[0]).toBe("bg-blue-500");
  });
  it("check length conversions", function () {
    let viewModel = new ConverterViewModel(lengthCard, 0);
    var conversions = viewModel.getConvertedValues("12");
    expect(conversions.map((item) => item.option.unit)).not.contains(
      Units.Gram
    );
    let inchItem =
      conversions.find((item) => item.option.unit == Units.Inch) ??
      conversions[0];
    expect(inchItem.value).toBeCloseTo(144);
    let mileItem =
      conversions.find((item) => item.option.unit == Units.Mile) ??
      conversions[0];
    viewModel.selectedUnit = mileItem.option;
    conversions = viewModel.getConvertedValues("5");
    let kiloValue =
      conversions.find((item) => item.option.unit == Units.Kilometer) ??
      conversions[0];
    expect(kiloValue.value).toBeCloseTo(8.05);
  });
});

describe("Temperature Conversion Tests", function () {
  let tempCard =
    allCategoryCards.find((card) => card.item == CategoryItems.TEMPERATURE) ??
    new CategoryCard(CategoryItems.TEMPERATURE);
  it("check temperature outputs", function () {
    expect(tempCard.title).toBe("Temperature");
    expect(tempCard.icon).toBe("fas fa-fire");
    expect(tempCard.colors[0]).toBe("bg-red-500");
  });
  it("check temperature conversions", function () {
    let viewModel = new ConverterViewModel(tempCard, 0);
    var conversions = viewModel.getConvertedValues("32");
    expect(conversions.map((item) => item.option.unit)).not.contains(
      Units.PoundForcePerSquareInch
    );
    let celciusItem =
      conversions.find((item) => item.option.unit == Units.Celsius) ??
      conversions[0];
    expect(celciusItem.value).toBe(0);
  });
});

describe("Mass Conversion Tests", function () {
  let massCard =
    allCategoryCards.find((card) => card.item == CategoryItems.MASS) ??
    new CategoryCard(CategoryItems.MASS);
  it("check mass outputs", function () {
    expect(massCard.title).toBe("Mass");
    expect(massCard.icon).toBe("fas fa-weight-scale");
    expect(massCard.colors[0]).toBe("bg-purple-500");
  });
  it("check mass conversions", function () {
    let viewModel = new ConverterViewModel(massCard, 0);
    var conversions = viewModel.getConvertedValues("460");
    expect(conversions.map((item) => item.option.unit)).not.contains(
      Units.Fahrenheit
    );
    let poundItem =
      conversions.find((item) => item.option.unit == Units.PoundLb) ??
      conversions[0];
    expect(poundItem.value).toBe(1);
  });
});

describe("Volume Conversion Tests", function () {
  let volumeCard =
    allCategoryCards.find((card) => card.item == CategoryItems.VOLUME) ??
    new CategoryCard(CategoryItems.VOLUME);
  it("check volume outputs", function () {
    expect(volumeCard.title).toBe("Volume");
    expect(volumeCard.icon).toBe("fas fa-droplet");
    expect(volumeCard.colors[0]).toBe("bg-orange-500");
  });
  it("check volume conversion", function () {
    let viewModel = new ConverterViewModel(volumeCard, 0);
    var conversions = viewModel.getConvertedValues("36");
    expect(conversions.map((item) => item.option.unit)).not.contains(
      Units.Gram
    );
    let gallonItem =
      conversions.find((item) => item.option.unit == Units.Gallon) ??
      conversions[0];
    expect(gallonItem.value).toBeCloseTo(9.5);
  });
});

describe("Pressure Conversion Tests", function () {
  let pressureCard =
    allCategoryCards.find((card) => card.item == CategoryItems.PRESSURE) ??
    new CategoryCard(CategoryItems.PRESSURE);
  it("check pressure outputs", function () {
    expect(pressureCard.title).toBe("Pressure");
    expect(pressureCard.icon).toBe("fas fa-gauge-simple");
    expect(pressureCard.colors[0]).toBe("bg-emerald-500");
  });
  it("check pressure conversion", function () {
    let viewModel = new ConverterViewModel(pressureCard, 0);
    var conversions = viewModel.getConvertedValues("2");
    expect(conversions.map((item) => item.option.unit)).not.contains(
      Units.Ampere
    );
    let barItem =
      conversions.find((item) => item.option.unit == Units.Bar) ??
      conversions[0];
    expect(barItem.value).toBeCloseTo(0.14);
  });
});

describe("Energy Conversion Tests", function () {
  let energyCard =
    allCategoryCards.find((card) => card.item == CategoryItems.ENERGY) ??
    new CategoryCard(CategoryItems.ENERGY);
  it("check energy outputs", function () {
    expect(energyCard.title).toBe("Energy");
    expect(energyCard.icon).toBe("fas fa-bolt");
    expect(energyCard.colors[0]).toBe("bg-yellow-500");
  });
  it("check energy conversion", function () {
    let viewModel = new ConverterViewModel(energyCard, 0);
    var conversions = viewModel.getConvertedValues("2600");
    expect(conversions.map((item) => item.option.unit)).not.contains(
      Units.Gallon
    );
    let kiloItem =
      conversions.find((item) => item.option.unit == Units.Kilojoule) ??
      conversions[0];
    expect(kiloItem.value).toBeCloseTo(2.6);
  });
});
